/*
 * Copyright 2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.codepipeline.jenkinsplugin;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

public class AWSClientFactory implements Serializable{
    public AWSClients getAwsClient(final String awsAccessKey,
                                   final String awsSecretKey,
                                   final String proxyHost,
                                   final int proxyPort,
                                   final String region) {
        final Region awsRegion = Region.getRegion(Regions.fromName(region));
        final AWSClients aws;

        if (StringUtils.isEmpty(awsAccessKey) && StringUtils.isEmpty(awsSecretKey)) {
            aws = AWSClients.fromDefaultCredentialChain(
                    awsRegion,
                    proxyHost,
                    proxyPort);
        }
        else {
            aws = AWSClients.fromBasicCredentials(
                    awsRegion,
                    awsAccessKey,
                    awsSecretKey,
                    proxyHost,
                    proxyPort);
        }

        return aws;
    }
}
