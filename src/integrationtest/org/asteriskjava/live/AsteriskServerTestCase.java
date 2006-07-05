/*
 *  Copyright 2004-2006 Stefan Reuter
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.asteriskjava.live;

import junit.framework.TestCase;

import org.asteriskjava.live.internal.AsteriskServerImpl;
import org.asteriskjava.manager.DefaultManagerConnection;

public class AsteriskServerTestCase extends TestCase
{
    protected AsteriskServerImpl server;
    protected DefaultManagerConnection managerConnection;

    @Override
    public void setUp() throws Exception
    {
        managerConnection = new DefaultManagerConnection();
        managerConnection.setHostname("pbx0");
        managerConnection.setUsername("manager");
        managerConnection.setPassword("obelisk");

        server = new AsteriskServerImpl();
        server.setManagerConnection(managerConnection);
        server.initialize();
    }

    @Override
    public void tearDown() throws Exception
    {
        managerConnection.logoff();
    }
}