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

package com.zuoxiaolong.niubi.job.scheduler;

/**
 * 自动管理的调度管理器,主要用于本地启动niubi-job时,管理任务的启动与暂停.
 *
 * @author Xiaolong Zuo
 * @since 0.9.4
 */
public interface AutomaticScheduleManager extends ScheduleManager {
    /**
     * 启动
     */
    void startup();

    /**
     * 启动 通过group
     * @param group
     */
    void startup(String group);

    /**
     * 启动 通过group 和 name
     * @param group
     * @param name
     */
    void startup(String group, String name);

}
