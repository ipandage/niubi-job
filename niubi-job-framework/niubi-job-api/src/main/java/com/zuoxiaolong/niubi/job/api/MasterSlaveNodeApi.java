package com.zuoxiaolong.niubi.job.api;

/*
 * Copyright 2002-2015 the original author or authors.
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

import com.zuoxiaolong.niubi.job.api.data.MasterSlaveNodeData;

import java.util.List;

/**
 * 主从模式下Node节点操作API
 *
 * @author Xiaolong Zuo
 * @since 0.9.3
 */
public interface MasterSlaveNodeApi extends NodeApi {
    /**
     * 获得所有节点
     * @return
     */
    List<MasterSlaveNodeData> getAllNodes();

    /**
     * 保存节点
     * @param data
     * @return
     */
    String saveNode(MasterSlaveNodeData.Data data);

    /**
     * 更新节点
     * @param path
     * @param data
     */
    void updateNode(String path, MasterSlaveNodeData.Data data);

    /**
     * 获得节点根据path
     * @param path
     * @return
     */
    MasterSlaveNodeData getNode(String path);

}
