/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zuoxiaolong.niubi.job.api;

/**
 * path操作API
 *
 * @author Xiaolong Zuo
 * @since 0.9.3
 */
public interface PathApi {
    /**
     * 获取初始化锁路径
     * @return
     */
    String getInitLockPath();

    /**
     * 获节点路径
     * @return
     */
    String getNodePath();

    /**
     * 获取选择器路径
     * @return
     */
    String getSelectorPath();

    /**
     * 获取job路径
     * @return
     */
    String getJobPath();

}
