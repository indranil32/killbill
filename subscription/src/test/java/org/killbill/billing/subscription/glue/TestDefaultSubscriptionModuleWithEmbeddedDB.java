/*
 * Copyright 2010-2013 Ning, Inc.
 * Copyright 2014-2018 Groupon, Inc
 * Copyright 2014-2018 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.subscription.glue;

import org.killbill.billing.GuicyKillbillTestWithEmbeddedDBModule;
import org.killbill.billing.account.glue.DefaultAccountModule;
import org.killbill.billing.platform.api.KillbillConfigSource;
import org.killbill.billing.subscription.engine.dao.MockSubscriptionDaoSql;
import org.killbill.billing.subscription.engine.dao.SubscriptionDao;
import org.killbill.billing.util.glue.AuditModule;
import org.killbill.billing.util.glue.CustomFieldModule;
import org.killbill.billing.util.glue.NonEntityDaoModule;
import org.killbill.clock.ClockMock;

public class TestDefaultSubscriptionModuleWithEmbeddedDB extends TestDefaultSubscriptionModule {

    private final ClockMock clock;

    public TestDefaultSubscriptionModuleWithEmbeddedDB(final KillbillConfigSource configSource, final ClockMock clock) {
        super(configSource);
        this.clock = clock;
    }

    @Override
    protected void installSubscriptionDao() {
        bind(SubscriptionDao.class).to(MockSubscriptionDaoSql.class).asEagerSingleton();
    }

    @Override
    protected void configure() {
        install(new GuicyKillbillTestWithEmbeddedDBModule(configSource, clock));
        install(new NonEntityDaoModule(configSource));
        install(new CustomFieldModule(configSource));
        install(new DefaultAccountModule(configSource));
        install(new AuditModule(configSource));
        super.configure();
    }
}
