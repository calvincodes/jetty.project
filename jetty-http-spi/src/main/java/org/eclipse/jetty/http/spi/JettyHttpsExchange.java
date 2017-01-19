//
//  ========================================================================
//  Copyright (c) 1995-2017 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.http.spi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;

import javax.net.ssl.SSLSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpPrincipal;
import com.sun.net.httpserver.HttpsExchange;

/* ------------------------------------------------------------ */
/**
 */
public class JettyHttpsExchange extends HttpsExchange implements JettyExchange
{
    private JettyHttpExchangeDelegate _delegate;

    public JettyHttpsExchange(HttpContext jaxWsContext, HttpServletRequest req, HttpServletResponse resp)
    {
        super();
        _delegate = new JettyHttpExchangeDelegate(jaxWsContext,req,resp);
    }

    @Override
    public int hashCode()
    {
        return _delegate.hashCode();
    }

    @Override
    public Headers getRequestHeaders()
    {
        return _delegate.getRequestHeaders();
    }

    @Override
    public Headers getResponseHeaders()
    {
        return _delegate.getResponseHeaders();
    }

    @Override
    public URI getRequestURI()
    {
        return _delegate.getRequestURI();
    }

    @Override
    public String getRequestMethod()
    {
        return _delegate.getRequestMethod();
    }

    @Override
    public HttpContext getHttpContext()
    {
        return _delegate.getHttpContext();
    }

    @Override
    public void close()
    {
        _delegate.close();
    }

    @Override
    public boolean equals(Object obj)
    {
        return _delegate.equals(obj);
    }

    @Override
    public InputStream getRequestBody()
    {
        return _delegate.getRequestBody();
    }

    @Override
    public OutputStream getResponseBody()
    {
        return _delegate.getResponseBody();
    }

    @Override
    public void sendResponseHeaders(int rCode, long responseLength) throws IOException
    {
        _delegate.sendResponseHeaders(rCode,responseLength);
    }

    @Override
    public InetSocketAddress getRemoteAddress()
    {
        return _delegate.getRemoteAddress();
    }

    @Override
    public int getResponseCode()
    {
        return _delegate.getResponseCode();
    }

    @Override
    public InetSocketAddress getLocalAddress()
    {
        return _delegate.getLocalAddress();
    }

    @Override
    public String getProtocol()
    {
        return _delegate.getProtocol();
    }

    @Override
    public Object getAttribute(String name)
    {
        return _delegate.getAttribute(name);
    }

    @Override
    public void setAttribute(String name, Object value)
    {
        _delegate.setAttribute(name,value);
    }

    @Override
    public void setStreams(InputStream i, OutputStream o)
    {
        _delegate.setStreams(i,o);
    }

    @Override
    public HttpPrincipal getPrincipal()
    {
        return _delegate.getPrincipal();
    }

    public void setPrincipal(HttpPrincipal principal)
    {
        _delegate.setPrincipal(principal);
    }

    @Override
    public String toString()
    {
        return _delegate.toString();
    }

    /* ------------------------------------------------------------ */
    /**
     * @see com.sun.net.httpserver.HttpsExchange#getSSLSession()
     */
    @Override
    public SSLSession getSSLSession()
    {
        return null;
    }

}
