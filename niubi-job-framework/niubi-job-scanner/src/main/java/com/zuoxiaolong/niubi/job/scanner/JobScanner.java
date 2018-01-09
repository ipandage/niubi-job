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

package com.zuoxiaolong.niubi.job.scanner;

import com.zuoxiaolong.niubi.job.scanner.job.JobDescriptor;

import java.util.List;

/**
 * 任务的扫描器.
 *
 * @author Xiaolong Zuo
 * @since 0.9.3
 */
public interface JobScanner {

    String APPLICATION_CONTEXT_XML_PATH = "applicationContext.xml";

    /**
     * 获得任务描述符
     * @return
     */
    List<JobDescriptor> getJobDescriptorList();

    /**
     * 是否是spring环境
     * @return
     */
    boolean hasSpringEnvironment();

}
