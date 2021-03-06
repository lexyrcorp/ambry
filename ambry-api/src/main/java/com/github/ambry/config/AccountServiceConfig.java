/*
 * Copyright 2020 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.github.ambry.config;

/**
 * Common config for {@link AccountServiceConfig}
 */
public class AccountServiceConfig {
  public static final String ACCOUNT_SERVICE_PREFIX = "account.service.";
  public static final String CONTAINER_ID_START_NUMBER = ACCOUNT_SERVICE_PREFIX + "container.id.start.number";

  /** The numeric container Id to be used for the first container created within an account. */
  @Config(CONTAINER_ID_START_NUMBER)
  @Default("1")
  public final short containerIdStartNumber;

  public AccountServiceConfig(VerifiableProperties verifiableProperties) {
    containerIdStartNumber =
        verifiableProperties.getShortInRange(CONTAINER_ID_START_NUMBER, (short) 1, (short) 0, Short.MAX_VALUE);
  }
}
