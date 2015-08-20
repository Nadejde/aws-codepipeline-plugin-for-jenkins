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

import com.amazonaws.regions.Regions;
import com.amazonaws.services.codepipeline.model.Job;

import java.io.Serializable;

public class CodePipelineStateModel implements Serializable {
    public enum CompressionType {
        None,
        Zip,
        Tar,
        TarGz
    }

    public enum CategoryType {
        PleaseChooseACategory("Please Choose A Category"),
        Build("Build"),
        Test("Test");

        private final String name;

        CategoryType(final String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static CategoryType fromName(final String name) {
            for (final CategoryType category : values()) {
                if (name.equals(category.getName())) {
                    return category;
                }
            }

            throw new IllegalArgumentException("Cannot create enum from " + name + " value!");
        }
    }

    private static final long serialVersionUID = 1L;
    public static final Regions[] AVAILABLE_REGIONS = { Regions.US_EAST_1 };
    public static final CategoryType[] ACTION_TYPE =
            { CategoryType.PleaseChooseACategory, CategoryType.Build, CategoryType.Test };

    private CompressionType compressionType;
    private CategoryType actionTypeCategory;
    private Job job;
    private String awsAccessKey;
    private String awsSecretKey;
    private String proxyHost;
    private int proxyPort;
    private String region;

    public int getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(final int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(final String region) {
        this.region = region;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(final String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public String getAwsSecretKey() {
        return awsSecretKey;
    }

    public void setAwsSecretKey(final String awsSecretKey) {
        this.awsSecretKey = awsSecretKey;
    }

    public String getAwsAccessKey() {
        return awsAccessKey;
    }

    public void setAwsAccessKey(final String awsAccessKey) {
        this.awsAccessKey = awsAccessKey;
    }

    public CodePipelineStateModel() {
        compressionType      = CompressionType.None;
        actionTypeCategory   = CategoryType.PleaseChooseACategory;
    }

    public CategoryType getActionTypeCategory() {
        return actionTypeCategory;
    }

    public void setActionTypeCategory(final String actionTypeCategory) {
        this.actionTypeCategory = CategoryType.fromName(actionTypeCategory);
    }

    public void clearJob() {
        job = null;
    }

    public void setJob(final Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public CompressionType getCompressionType() {
        return compressionType;
    }

    public void setCompressionType(final CompressionType compressionType) {
        if (compressionType == null) {
            this.compressionType = CompressionType.None;
        }
        else {
            this.compressionType = compressionType;
        }
    }
}
