/*
 * Copyright 2010-2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.ec2;

import org.w3c.dom.*;

import java.net.*;
import java.util.*;
import java.util.Map.Entry;

import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.handlers.*;
import com.amazonaws.http.*;
import com.amazonaws.internal.*;
import com.amazonaws.metrics.*;
import com.amazonaws.regions.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.*;
import com.amazonaws.util.AWSRequestMetrics.Field;

import com.amazonaws.services.ec2.model.*;
import com.amazonaws.services.ec2.model.transform.*;

/**
 * Client for accessing AmazonEC2.  All service calls made
 * using this client are blocking, and will not return until the service call
 * completes.
 * <p>
 * Amazon EC2 <p>
 * Amazon Elastic Compute Cloud (Amazon EC2) is a web service that provides resizable compute capacity in the cloud. It is designed to make web-scale
 * computing easier for developers.
 * </p>
 * <p>
 * Amazon EC2's simple web service interface allows you to obtain and configure capacity with minimal friction. It provides you with complete control of
 * your computing resources and lets you run on Amazon's proven computing environment. Amazon EC2 reduces the time required to obtain and boot new server
 * instances to minutes, allowing you to quickly scale capacity, both up and down, as your computing requirements change. Amazon EC2 changes the
 * economics of computing by allowing you to pay only for capacity that you actually use. Amazon EC2 provides developers the tools to build failure
 * resilient applications and isolate themselves from common failure scenarios.
 * </p>
 * <p>
 * Visit <a href="http://aws.amazon.com/ec2/"> http://aws.amazon.com/ec2/ </a> for more information.
 * </p>
 * <p>
 * See our blog to learn more about {@see <a href="http://mobile.awsblog.com/post/Tx31X75XISXHRH8/Managing-Credentials-in-Mobile-Applications">Managing Credentials in Mobile Applications</a>.}
 * </p>
 */
public class AmazonEC2Client extends AmazonWebServiceClient implements AmazonEC2 {

    /** Provider for AWS credentials. */
    private AWSCredentialsProvider awsCredentialsProvider;

    /**
     * List of exception unmarshallers for all AmazonEC2 exceptions.
     */
    protected final List<Unmarshaller<AmazonServiceException, Node>> exceptionUnmarshallers
            = new ArrayList<Unmarshaller<AmazonServiceException, Node>>();

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonEC2Client() {
        this(new DefaultAWSCredentialsProviderChain(), new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2.  A credentials provider chain will be used
     * that searches for credentials in this order:
     * <ul>
     *  <li> Environment Variables - AWS_ACCESS_KEY_ID and AWS_SECRET_KEY </li>
     *  <li> Java System Properties - aws.accessKeyId and aws.secretKey </li>
     *  <li> Instance profile credentials delivered through the Amazon EC2 metadata service </li>
     * </ul>
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonEC2
     *                       (ex: proxy settings, retry counts, etc.).
     *
     * @see DefaultAWSCredentialsProviderChain
     */
    public AmazonEC2Client(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2 using the specified AWS account credentials.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     */
    public AmazonEC2Client(AWSCredentials awsCredentials) {
        this(awsCredentials, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2 using the specified AWS account credentials
     * and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentials The AWS credentials (access key ID and secret key) to use
     *                       when authenticating with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonEC2
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonEC2Client(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration) {
        super(clientConfiguration);
        this.awsCredentialsProvider = new StaticCredentialsProvider(awsCredentials);
        init();
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2 using the specified AWS account credentials provider.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     */
    public AmazonEC2Client(AWSCredentialsProvider awsCredentialsProvider) {
        this(awsCredentialsProvider, new ClientConfiguration());
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2 using the specified AWS account credentials
     * provider and client configuration options.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonEC2
     *                       (ex: proxy settings, retry counts, etc.).
     */
    public AmazonEC2Client(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration) {
        this(awsCredentialsProvider, clientConfiguration, null);
    }

    /**
     * Constructs a new client to invoke service methods on
     * AmazonEC2 using the specified AWS account credentials
     * provider, client configuration options, and request metric collector.
     *
     * <p>
     * All service calls made using this new client object are blocking, and will not
     * return until the service call completes.
     *
     * @param awsCredentialsProvider
     *            The AWS credentials provider which will provide credentials
     *            to authenticate requests with AWS services.
     * @param clientConfiguration The client configuration options controlling how this
     *                       client connects to AmazonEC2
     *                       (ex: proxy settings, retry counts, etc.).
     * @param requestMetricCollector optional request metric collector
     */
    public AmazonEC2Client(AWSCredentialsProvider awsCredentialsProvider,
            ClientConfiguration clientConfiguration,
            RequestMetricCollector requestMetricCollector) {
        super(clientConfiguration, requestMetricCollector);
        this.awsCredentialsProvider = awsCredentialsProvider;
        init();
    }

    private void init() {
        
        exceptionUnmarshallers.add(new LegacyErrorUnmarshaller());
        // calling this.setEndPoint(...) will also modify the signer accordingly
        this.setEndpoint("ec2.amazonaws.com");
        HandlerChainFactory chainFactory = new HandlerChainFactory();
        requestHandler2s.addAll(chainFactory.newRequestHandlerChain(
                "/com/amazonaws/services/ec2/request.handlers"));
        requestHandler2s.addAll(chainFactory.newRequestHandler2Chain(
                "/com/amazonaws/services/ec2/request.handler2s"));
    }

    /**
     * <p>
     * The RebootInstances operation requests a reboot of one or more
     * instances. This operation is asynchronous; it only queues a request to
     * reboot the specified instance(s). The operation will succeed if the
     * instances are valid and belong to the user. Requests to reboot
     * terminated instances are ignored.
     * </p>
     *
     * @param rebootInstancesRequest Container for the necessary parameters
     *           to execute the RebootInstances service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void rebootInstances(RebootInstancesRequest rebootInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(rebootInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RebootInstancesRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RebootInstancesRequestMarshaller().marshall(rebootInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The DescribeReservedInstances operation describes Reserved Instances
     * that were purchased for use with your account.
     * </p>
     *
     * @param describeReservedInstancesRequest Container for the necessary
     *           parameters to execute the DescribeReservedInstances service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeReservedInstances service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesResult describeReservedInstances(DescribeReservedInstancesRequest describeReservedInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeReservedInstancesRequest> request = null;
        Response<DescribeReservedInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeReservedInstancesRequestMarshaller().marshall(describeReservedInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeReservedInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeAvailabilityZones operation describes availability zones
     * that are currently available to the account and their states.
     * </p>
     * <p>
     * Availability zones are not the same across accounts. The availability
     * zone <code>us-east-1a</code> for account A is not necessarily the same
     * as <code>us-east-1a</code> for account B. Zone assignments are mapped
     * independently for each account.
     * </p>
     *
     * @param describeAvailabilityZonesRequest Container for the necessary
     *           parameters to execute the DescribeAvailabilityZones service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeAvailabilityZones service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAvailabilityZonesResult describeAvailabilityZones(DescribeAvailabilityZonesRequest describeAvailabilityZonesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeAvailabilityZonesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeAvailabilityZonesRequest> request = null;
        Response<DescribeAvailabilityZonesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeAvailabilityZonesRequestMarshaller().marshall(describeAvailabilityZonesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeAvailabilityZonesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Detach a previously attached volume from a running instance.
     * </p>
     *
     * @param detachVolumeRequest Container for the necessary parameters to
     *           execute the DetachVolume service method on AmazonEC2.
     * 
     * @return The response from the DetachVolume service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DetachVolumeResult detachVolume(DetachVolumeRequest detachVolumeRequest) {
        ExecutionContext executionContext = createExecutionContext(detachVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DetachVolumeRequest> request = null;
        Response<DetachVolumeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DetachVolumeRequestMarshaller().marshall(detachVolumeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DetachVolumeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DeleteKeyPair operation deletes a key pair.
     * </p>
     *
     * @param deleteKeyPairRequest Container for the necessary parameters to
     *           execute the DeleteKeyPair service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteKeyPair(DeleteKeyPairRequest deleteKeyPairRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteKeyPairRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteKeyPairRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteKeyPairRequestMarshaller().marshall(deleteKeyPairRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Disables monitoring for a running instance.
     * </p>
     *
     * @param unmonitorInstancesRequest Container for the necessary
     *           parameters to execute the UnmonitorInstances service method on
     *           AmazonEC2.
     * 
     * @return The response from the UnmonitorInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public UnmonitorInstancesResult unmonitorInstances(UnmonitorInstancesRequest unmonitorInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(unmonitorInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<UnmonitorInstancesRequest> request = null;
        Response<UnmonitorInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new UnmonitorInstancesRequestMarshaller().marshall(unmonitorInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new UnmonitorInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates an Amazon EBS-backed AMI from a "running" or "stopped"
     * instance. AMIs that use an Amazon EBS root device boot faster than
     * AMIs that use instance stores. They can be up to 1 TiB in size, use
     * storage that persists on instance failure, and can be stopped and
     * started.
     * </p>
     *
     * @param createImageRequest Container for the necessary parameters to
     *           execute the CreateImage service method on AmazonEC2.
     * 
     * @return The response from the CreateImage service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateImageResult createImage(CreateImageRequest createImageRequest) {
        ExecutionContext executionContext = createExecutionContext(createImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateImageRequest> request = null;
        Response<CreateImageResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateImageRequestMarshaller().marshall(createImageRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateImageResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DeleteSecurityGroup operation deletes a security group.
     * </p>
     * <p>
     * <b>NOTE:</b> If you attempt to delete a security group that contains
     * instances, a fault is returned. If you attempt to delete a security
     * group that is referenced by another security group, a fault is
     * returned. For example, if security group B has a rule that allows
     * access from security group A, security group A cannot be deleted until
     * the allow rule is removed.
     * </p>
     *
     * @param deleteSecurityGroupRequest Container for the necessary
     *           parameters to execute the DeleteSecurityGroup service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteSecurityGroup(DeleteSecurityGroupRequest deleteSecurityGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteSecurityGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteSecurityGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteSecurityGroupRequestMarshaller().marshall(deleteSecurityGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param createInstanceExportTaskRequest Container for the necessary
     *           parameters to execute the CreateInstanceExportTask service method on
     *           AmazonEC2.
     * 
     * @return The response from the CreateInstanceExportTask service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateInstanceExportTaskResult createInstanceExportTask(CreateInstanceExportTaskRequest createInstanceExportTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(createInstanceExportTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateInstanceExportTaskRequest> request = null;
        Response<CreateInstanceExportTaskResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateInstanceExportTaskRequestMarshaller().marshall(createInstanceExportTaskRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateInstanceExportTaskResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Retrieves the encrypted administrator password for the instances
     * running Windows.
     * </p>
     * <p>
     * <b>NOTE:</b> The Windows password is only generated the first time an
     * AMI is launched. It is not generated for rebundled AMIs or after the
     * password is changed on an instance. The password is encrypted using
     * the key pair that you provided.
     * </p>
     *
     * @param getPasswordDataRequest Container for the necessary parameters
     *           to execute the GetPasswordData service method on AmazonEC2.
     * 
     * @return The response from the GetPasswordData service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetPasswordDataResult getPasswordData(GetPasswordDataRequest getPasswordDataRequest) {
        ExecutionContext executionContext = createExecutionContext(getPasswordDataRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<GetPasswordDataRequest> request = null;
        Response<GetPasswordDataResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new GetPasswordDataRequestMarshaller().marshall(getPasswordDataRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new GetPasswordDataResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Stops an instance that uses an Amazon EBS volume as its root device.
     * Instances that use Amazon EBS volumes as their root devices can be
     * quickly stopped and started. When an instance is stopped, the compute
     * resources are released and you are not billed for hourly instance
     * usage. However, your root partition Amazon EBS volume remains,
     * continues to persist your data, and you are charged for Amazon EBS
     * volume usage. You can restart your instance at any time.
     * </p>
     * <p>
     * <b>NOTE:</b> Before stopping an instance, make sure it is in a state
     * from which it can be restarted. Stopping an instance does not preserve
     * data stored in RAM. Performing this operation on an instance that uses
     * an instance store as its root device returns an error.
     * </p>
     *
     * @param stopInstancesRequest Container for the necessary parameters to
     *           execute the StopInstances service method on AmazonEC2.
     * 
     * @return The response from the StopInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public StopInstancesResult stopInstances(StopInstancesRequest stopInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(stopInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<StopInstancesRequest> request = null;
        Response<StopInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new StopInstancesRequestMarshaller().marshall(stopInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new StopInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Imports the public key from an RSA key pair created with a
     * third-party tool. This operation differs from CreateKeyPair as the
     * private key is never transferred between the caller and AWS servers.
     * </p>
     * <p>
     * RSA key pairs are easily created on Microsoft Windows and Linux OS
     * systems using the <code>ssh-keygen</code> command line tool provided
     * with the standard OpenSSH installation. Standard library support for
     * RSA key pair creation is also available for Java, Ruby, Python, and
     * many other programming languages.
     * </p>
     * <p>
     * The following formats are supported:
     * </p>
     * 
     * <ul>
     * <li> OpenSSH public key format, </li>
     * <li> Base64 encoded DER format. </li>
     * <li> SSH public key file format as specified in <a
     * href="http://tools.ietf.org/html/rfc4716"> RFC4716 </a> . </li>
     * 
     * </ul>
     *
     * @param importKeyPairRequest Container for the necessary parameters to
     *           execute the ImportKeyPair service method on AmazonEC2.
     * 
     * @return The response from the ImportKeyPair service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ImportKeyPairResult importKeyPair(ImportKeyPairRequest importKeyPairRequest) {
        ExecutionContext executionContext = createExecutionContext(importKeyPairRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ImportKeyPairRequest> request = null;
        Response<ImportKeyPairResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ImportKeyPairRequestMarshaller().marshall(importKeyPairRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new ImportKeyPairResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The CreateSecurityGroup operation creates a new security group.
     * </p>
     * <p>
     * Every instance is launched in a security group. If no security group
     * is specified during launch, the instances are launched in the default
     * security group. Instances within the same security group have
     * unrestricted network access to each other. Instances will reject
     * network access attempts from other instances in a different security
     * group. As the owner of instances you can grant or revoke specific
     * permissions using the AuthorizeSecurityGroupIngress and
     * RevokeSecurityGroupIngress operations.
     * </p>
     *
     * @param createSecurityGroupRequest Container for the necessary
     *           parameters to execute the CreateSecurityGroup service method on
     *           AmazonEC2.
     * 
     * @return The response from the CreateSecurityGroup service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateSecurityGroupResult createSecurityGroup(CreateSecurityGroupRequest createSecurityGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(createSecurityGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateSecurityGroupRequest> request = null;
        Response<CreateSecurityGroupResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateSecurityGroupRequestMarshaller().marshall(createSecurityGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateSecurityGroupResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes the Spot Price history.
     * </p>
     * <p>
     * Spot Instances are instances that Amazon EC2 starts on your behalf
     * when the maximum price that you specify exceeds the current Spot
     * Price. Amazon EC2 periodically sets the Spot Price based on available
     * Spot Instance capacity and current spot instance requests.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     *
     * @param describeSpotPriceHistoryRequest Container for the necessary
     *           parameters to execute the DescribeSpotPriceHistory service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeSpotPriceHistory service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSpotPriceHistoryResult describeSpotPriceHistory(DescribeSpotPriceHistoryRequest describeSpotPriceHistoryRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSpotPriceHistoryRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSpotPriceHistoryRequest> request = null;
        Response<DescribeSpotPriceHistoryResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSpotPriceHistoryRequestMarshaller().marshall(describeSpotPriceHistoryRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSpotPriceHistoryResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeRegions operation describes regions zones that are
     * currently available to the account.
     * </p>
     *
     * @param describeRegionsRequest Container for the necessary parameters
     *           to execute the DescribeRegions service method on AmazonEC2.
     * 
     * @return The response from the DescribeRegions service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeRegionsResult describeRegions(DescribeRegionsRequest describeRegionsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeRegionsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeRegionsRequest> request = null;
        Response<DescribeRegionsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeRegionsRequestMarshaller().marshall(describeRegionsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeRegionsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param createReservedInstancesListingRequest Container for the
     *           necessary parameters to execute the CreateReservedInstancesListing
     *           service method on AmazonEC2.
     * 
     * @return The response from the CreateReservedInstancesListing service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateReservedInstancesListingResult createReservedInstancesListing(CreateReservedInstancesListingRequest createReservedInstancesListingRequest) {
        ExecutionContext executionContext = createExecutionContext(createReservedInstancesListingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateReservedInstancesListingRequest> request = null;
        Response<CreateReservedInstancesListingResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateReservedInstancesListingRequestMarshaller().marshall(createReservedInstancesListingRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateReservedInstancesListingResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Resets permission settings for the specified snapshot.
     * </p>
     *
     * @param resetSnapshotAttributeRequest Container for the necessary
     *           parameters to execute the ResetSnapshotAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void resetSnapshotAttribute(ResetSnapshotAttributeRequest resetSnapshotAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(resetSnapshotAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ResetSnapshotAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ResetSnapshotAttributeRequestMarshaller().marshall(resetSnapshotAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param importVolumeRequest Container for the necessary parameters to
     *           execute the ImportVolume service method on AmazonEC2.
     * 
     * @return The response from the ImportVolume service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ImportVolumeResult importVolume(ImportVolumeRequest importVolumeRequest) {
        ExecutionContext executionContext = createExecutionContext(importVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ImportVolumeRequest> request = null;
        Response<ImportVolumeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ImportVolumeRequestMarshaller().marshall(importVolumeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new ImportVolumeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeSecurityGroups operation returns information about
     * security groups that you own.
     * </p>
     * <p>
     * If you specify security group names, information about those security
     * group is returned. Otherwise, information for all security group is
     * returned. If you specify a group that does not exist, a fault is
     * returned.
     * </p>
     *
     * @param describeSecurityGroupsRequest Container for the necessary
     *           parameters to execute the DescribeSecurityGroups service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeSecurityGroups service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSecurityGroupsResult describeSecurityGroups(DescribeSecurityGroupsRequest describeSecurityGroupsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSecurityGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSecurityGroupsRequest> request = null;
        Response<DescribeSecurityGroupsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSecurityGroupsRequestMarshaller().marshall(describeSecurityGroupsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSecurityGroupsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DeregisterImage operation deregisters an AMI. Once deregistered,
     * instances of the AMI can no longer be launched.
     * </p>
     *
     * @param deregisterImageRequest Container for the necessary parameters
     *           to execute the DeregisterImage service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deregisterImage(DeregisterImageRequest deregisterImageRequest) {
        ExecutionContext executionContext = createExecutionContext(deregisterImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeregisterImageRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeregisterImageRequestMarshaller().marshall(deregisterImageRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Describes the data feed for Spot Instances.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     *
     * @param describeSpotDatafeedSubscriptionRequest Container for the
     *           necessary parameters to execute the DescribeSpotDatafeedSubscription
     *           service method on AmazonEC2.
     * 
     * @return The response from the DescribeSpotDatafeedSubscription service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription(DescribeSpotDatafeedSubscriptionRequest describeSpotDatafeedSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSpotDatafeedSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSpotDatafeedSubscriptionRequest> request = null;
        Response<DescribeSpotDatafeedSubscriptionResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSpotDatafeedSubscriptionRequestMarshaller().marshall(describeSpotDatafeedSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes tags from the specified Amazon EC2 resources.
     * </p>
     *
     * @param deleteTagsRequest Container for the necessary parameters to
     *           execute the DeleteTags service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteTags(DeleteTagsRequest deleteTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteTagsRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteTagsRequestMarshaller().marshall(deleteTagsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param describeAccountAttributesRequest Container for the necessary
     *           parameters to execute the DescribeAccountAttributes service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeAccountAttributes service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAccountAttributesResult describeAccountAttributes(DescribeAccountAttributesRequest describeAccountAttributesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeAccountAttributesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeAccountAttributesRequest> request = null;
        Response<DescribeAccountAttributesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeAccountAttributesRequestMarshaller().marshall(describeAccountAttributesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeAccountAttributesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Enable IO on the volume after an event has occured.
     * </p>
     *
     * @param enableVolumeIORequest Container for the necessary parameters to
     *           execute the EnableVolumeIO service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void enableVolumeIO(EnableVolumeIORequest enableVolumeIORequest) {
        ExecutionContext executionContext = createExecutionContext(enableVolumeIORequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<EnableVolumeIORequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new EnableVolumeIORequestMarshaller().marshall(enableVolumeIORequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Attach a previously created volume to a running instance.
     * </p>
     *
     * @param attachVolumeRequest Container for the necessary parameters to
     *           execute the AttachVolume service method on AmazonEC2.
     * 
     * @return The response from the AttachVolume service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AttachVolumeResult attachVolume(AttachVolumeRequest attachVolumeRequest) {
        ExecutionContext executionContext = createExecutionContext(attachVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AttachVolumeRequest> request = null;
        Response<AttachVolumeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AttachVolumeRequestMarshaller().marshall(attachVolumeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new AttachVolumeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Provides details of a user's registered licenses. Zero or more IDs
     * may be specified on the call. When one or more license IDs are
     * specified, only data for the specified IDs are returned.
     * </p>
     *
     * @param describeLicensesRequest Container for the necessary parameters
     *           to execute the DescribeLicenses service method on AmazonEC2.
     * 
     * @return The response from the DescribeLicenses service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeLicensesResult describeLicenses(DescribeLicensesRequest describeLicensesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeLicensesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeLicensesRequest> request = null;
        Response<DescribeLicensesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeLicensesRequestMarshaller().marshall(describeLicensesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeLicensesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes the status of a volume.
     * </p>
     *
     * @param describeVolumeStatusRequest Container for the necessary
     *           parameters to execute the DescribeVolumeStatus service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeVolumeStatus service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVolumeStatusResult describeVolumeStatus(DescribeVolumeStatusRequest describeVolumeStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(describeVolumeStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeVolumeStatusRequest> request = null;
        Response<DescribeVolumeStatusResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeVolumeStatusRequestMarshaller().marshall(describeVolumeStatusRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeVolumeStatusResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Activates a specific number of licenses for a 90-day period.
     * Activations can be done against a specific license ID.
     * </p>
     *
     * @param activateLicenseRequest Container for the necessary parameters
     *           to execute the ActivateLicense service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void activateLicense(ActivateLicenseRequest activateLicenseRequest) {
        ExecutionContext executionContext = createExecutionContext(activateLicenseRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ActivateLicenseRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ActivateLicenseRequestMarshaller().marshall(activateLicenseRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The ResetImageAttribute operation resets an attribute of an AMI to
     * its default value.
     * </p>
     * <p>
     * <b>NOTE:</b> The productCodes attribute cannot be reset.
     * </p>
     *
     * @param resetImageAttributeRequest Container for the necessary
     *           parameters to execute the ResetImageAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void resetImageAttribute(ResetImageAttributeRequest resetImageAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(resetImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ResetImageAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ResetImageAttributeRequestMarshaller().marshall(resetImageAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Create a snapshot of the volume identified by volume ID. A volume
     * does not have to be detached at the time the snapshot is taken.
     * </p>
     * <p>
     * <b>NOTE:</b> Snapshot creation requires that the system is in a
     * consistent state. For instance, this means that if taking a snapshot
     * of a database, the tables must be read-only locked to ensure that the
     * snapshot will not contain a corrupted version of the database.
     * Therefore, be careful when using this API to ensure that the system
     * remains in the consistent state until the create snapshot status has
     * returned.
     * </p>
     *
     * @param createSnapshotRequest Container for the necessary parameters to
     *           execute the CreateSnapshot service method on AmazonEC2.
     * 
     * @return The response from the CreateSnapshot service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateSnapshotResult createSnapshot(CreateSnapshotRequest createSnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(createSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateSnapshotRequest> request = null;
        Response<CreateSnapshotResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateSnapshotRequestMarshaller().marshall(createSnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateSnapshotResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a previously created volume. Once successfully deleted, a
     * new volume can be created with the same name.
     * </p>
     *
     * @param deleteVolumeRequest Container for the necessary parameters to
     *           execute the DeleteVolume service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteVolume(DeleteVolumeRequest deleteVolumeRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteVolumeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteVolumeRequestMarshaller().marshall(deleteVolumeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The ModifyReservedInstances operation modifies the Availability Zone,
     * instance count, instance type, or network platform (EC2-Classic or
     * EC2-VPC) of your Reserved Instances.
     * </p>
     *
     * @param modifyReservedInstancesRequest Container for the necessary
     *           parameters to execute the ModifyReservedInstances service method on
     *           AmazonEC2.
     * 
     * @return The response from the ModifyReservedInstances service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ModifyReservedInstancesResult modifyReservedInstances(ModifyReservedInstancesRequest modifyReservedInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyReservedInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyReservedInstancesRequest> request = null;
        Response<ModifyReservedInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyReservedInstancesRequestMarshaller().marshall(modifyReservedInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new ModifyReservedInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gives you information about your VPCs. You can filter the results to
     * return information only about VPCs that match criteria you specify.
     * </p>
     * <p>
     * For example, you could ask to get information about a particular VPC
     * or VPCs (or all your VPCs) only if the VPC's state is available. You
     * can specify multiple filters (e.g., the VPC uses one of several sets
     * of DHCP options, and the VPC's state is available). The result
     * includes information for a particular VPC only if the VPC matches all
     * your filters.
     * </p>
     * <p>
     * If there's no match, no special message is returned; the response is
     * simply empty. The following table shows the available filters.
     * </p>
     *
     * @param describeVpcsRequest Container for the necessary parameters to
     *           execute the DescribeVpcs service method on AmazonEC2.
     * 
     * @return The response from the DescribeVpcs service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVpcsResult describeVpcs(DescribeVpcsRequest describeVpcsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeVpcsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeVpcsRequest> request = null;
        Response<DescribeVpcsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeVpcsRequestMarshaller().marshall(describeVpcsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeVpcsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param cancelConversionTaskRequest Container for the necessary
     *           parameters to execute the CancelConversionTask service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void cancelConversionTask(CancelConversionTaskRequest cancelConversionTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(cancelConversionTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CancelConversionTaskRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CancelConversionTaskRequestMarshaller().marshall(cancelConversionTaskRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The AssociateAddress operation associates an elastic IP address with
     * an instance.
     * </p>
     * <p>
     * If the IP address is currently assigned to another instance, the IP
     * address is assigned to the new instance. This is an idempotent
     * operation. If you enter it more than once, Amazon EC2 does not return
     * an error.
     * </p>
     *
     * @param associateAddressRequest Container for the necessary parameters
     *           to execute the AssociateAddress service method on AmazonEC2.
     * 
     * @return The response from the AssociateAddress service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AssociateAddressResult associateAddress(AssociateAddressRequest associateAddressRequest) {
        ExecutionContext executionContext = createExecutionContext(associateAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AssociateAddressRequest> request = null;
        Response<AssociateAddressResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AssociateAddressRequestMarshaller().marshall(associateAddressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new AssociateAddressResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deactivates a specific number of licenses. Deactivations can be done
     * against a specific license ID after they have persisted for at least a
     * 90-day period.
     * </p>
     *
     * @param deactivateLicenseRequest Container for the necessary parameters
     *           to execute the DeactivateLicense service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deactivateLicense(DeactivateLicenseRequest deactivateLicenseRequest) {
        ExecutionContext executionContext = createExecutionContext(deactivateLicenseRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeactivateLicenseRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeactivateLicenseRequestMarshaller().marshall(deactivateLicenseRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param describeExportTasksRequest Container for the necessary
     *           parameters to execute the DescribeExportTasks service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeExportTasks service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeExportTasksResult describeExportTasks(DescribeExportTasksRequest describeExportTasksRequest) {
        ExecutionContext executionContext = createExecutionContext(describeExportTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeExportTasksRequest> request = null;
        Response<DescribeExportTasksResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeExportTasksRequestMarshaller().marshall(describeExportTasksRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeExportTasksResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes the status of the indicated volume or, in lieu of any
     * specified, all volumes belonging to the caller. Volumes that have been
     * deleted are not described.
     * </p>
     *
     * @param describeVolumesRequest Container for the necessary parameters
     *           to execute the DescribeVolumes service method on AmazonEC2.
     * 
     * @return The response from the DescribeVolumes service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVolumesResult describeVolumes(DescribeVolumesRequest describeVolumesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeVolumesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeVolumesRequest> request = null;
        Response<DescribeVolumesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeVolumesRequestMarshaller().marshall(describeVolumesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeVolumesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param describeReservedInstancesListingsRequest Container for the
     *           necessary parameters to execute the DescribeReservedInstancesListings
     *           service method on AmazonEC2.
     * 
     * @return The response from the DescribeReservedInstancesListings
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesListingsResult describeReservedInstancesListings(DescribeReservedInstancesListingsRequest describeReservedInstancesListingsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesListingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeReservedInstancesListingsRequest> request = null;
        Response<DescribeReservedInstancesListingsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeReservedInstancesListingsRequestMarshaller().marshall(describeReservedInstancesListingsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeReservedInstancesListingsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param reportInstanceStatusRequest Container for the necessary
     *           parameters to execute the ReportInstanceStatus service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void reportInstanceStatus(ReportInstanceStatusRequest reportInstanceStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(reportInstanceStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ReportInstanceStatusRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ReportInstanceStatusRequestMarshaller().marshall(reportInstanceStatusRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Enables monitoring for a running instance.
     * </p>
     *
     * @param monitorInstancesRequest Container for the necessary parameters
     *           to execute the MonitorInstances service method on AmazonEC2.
     * 
     * @return The response from the MonitorInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public MonitorInstancesResult monitorInstances(MonitorInstancesRequest monitorInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(monitorInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<MonitorInstancesRequest> request = null;
        Response<MonitorInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new MonitorInstancesRequestMarshaller().marshall(monitorInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new MonitorInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeBundleTasks operation describes in-progress and recent
     * bundle tasks. Complete and failed tasks are removed from the list a
     * short time after completion. If no bundle ids are given, all bundle
     * tasks are returned.
     * </p>
     *
     * @param describeBundleTasksRequest Container for the necessary
     *           parameters to execute the DescribeBundleTasks service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeBundleTasks service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeBundleTasksResult describeBundleTasks(DescribeBundleTasksRequest describeBundleTasksRequest) {
        ExecutionContext executionContext = createExecutionContext(describeBundleTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeBundleTasksRequest> request = null;
        Response<DescribeBundleTasksResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeBundleTasksRequestMarshaller().marshall(describeBundleTasksRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeBundleTasksResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param importInstanceRequest Container for the necessary parameters to
     *           execute the ImportInstance service method on AmazonEC2.
     * 
     * @return The response from the ImportInstance service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ImportInstanceResult importInstance(ImportInstanceRequest importInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(importInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ImportInstanceRequest> request = null;
        Response<ImportInstanceResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ImportInstanceRequestMarshaller().marshall(importInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new ImportInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The RevokeSecurityGroupIngress operation revokes permissions from a
     * security group. The permissions used to revoke must be specified using
     * the same values used to grant the permissions.
     * </p>
     * <p>
     * Permissions are specified by IP protocol (TCP, UDP, or ICMP), the
     * source of the request (by IP range or an Amazon EC2 user-group pair),
     * the source and destination port ranges (for TCP and UDP), and the ICMP
     * codes and types (for ICMP).
     * </p>
     * <p>
     * Permission changes are quickly propagated to instances within the
     * security group. However, depending on the number of instances in the
     * group, a small delay might occur.
     * </p>
     *
     * @param revokeSecurityGroupIngressRequest Container for the necessary
     *           parameters to execute the RevokeSecurityGroupIngress service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void revokeSecurityGroupIngress(RevokeSecurityGroupIngressRequest revokeSecurityGroupIngressRequest) {
        ExecutionContext executionContext = createExecutionContext(revokeSecurityGroupIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RevokeSecurityGroupIngressRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RevokeSecurityGroupIngressRequestMarshaller().marshall(revokeSecurityGroupIngressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The GetConsoleOutput operation retrieves console output for the
     * specified instance.
     * </p>
     * <p>
     * Instance console output is buffered and posted shortly after instance
     * boot, reboot, and termination. Amazon EC2 preserves the most recent 64
     * KB output which will be available for at least one hour after the most
     * recent post.
     * </p>
     *
     * @param getConsoleOutputRequest Container for the necessary parameters
     *           to execute the GetConsoleOutput service method on AmazonEC2.
     * 
     * @return The response from the GetConsoleOutput service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public GetConsoleOutputResult getConsoleOutput(GetConsoleOutputRequest getConsoleOutputRequest) {
        ExecutionContext executionContext = createExecutionContext(getConsoleOutputRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<GetConsoleOutputRequest> request = null;
        Response<GetConsoleOutputResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new GetConsoleOutputRequestMarshaller().marshall(getConsoleOutputRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new GetConsoleOutputResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The ModifyImageAttribute operation modifies an attribute of an AMI.
     * </p>
     *
     * @param modifyImageAttributeRequest Container for the necessary
     *           parameters to execute the ModifyImageAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void modifyImageAttribute(ModifyImageAttributeRequest modifyImageAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyImageAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyImageAttributeRequestMarshaller().marshall(modifyImageAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Creates the data feed for Spot Instances, enabling you to view Spot
     * Instance usage logs. You can create one data feed per account.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     *
     * @param createSpotDatafeedSubscriptionRequest Container for the
     *           necessary parameters to execute the CreateSpotDatafeedSubscription
     *           service method on AmazonEC2.
     * 
     * @return The response from the CreateSpotDatafeedSubscription service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateSpotDatafeedSubscriptionResult createSpotDatafeedSubscription(CreateSpotDatafeedSubscriptionRequest createSpotDatafeedSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(createSpotDatafeedSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateSpotDatafeedSubscriptionRequest> request = null;
        Response<CreateSpotDatafeedSubscriptionResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateSpotDatafeedSubscriptionRequestMarshaller().marshall(createSpotDatafeedSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateSpotDatafeedSubscriptionResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param describeConversionTasksRequest Container for the necessary
     *           parameters to execute the DescribeConversionTasks service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeConversionTasks service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeConversionTasksResult describeConversionTasks(DescribeConversionTasksRequest describeConversionTasksRequest) {
        ExecutionContext executionContext = createExecutionContext(describeConversionTasksRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeConversionTasksRequest> request = null;
        Response<DescribeConversionTasksResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeConversionTasksRequestMarshaller().marshall(describeConversionTasksRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeConversionTasksResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns information about an attribute of an instance. Only one
     * attribute can be specified per call.
     * </p>
     *
     * @param describeInstanceAttributeRequest Container for the necessary
     *           parameters to execute the DescribeInstanceAttribute service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeInstanceAttribute service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeInstanceAttributeResult describeInstanceAttribute(DescribeInstanceAttributeRequest describeInstanceAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(describeInstanceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeInstanceAttributeRequest> request = null;
        Response<DescribeInstanceAttributeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeInstanceAttributeRequestMarshaller().marshall(describeInstanceAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeInstanceAttributeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns information about one or more PlacementGroup instances in a
     * user's account.
     * </p>
     *
     * @param describePlacementGroupsRequest Container for the necessary
     *           parameters to execute the DescribePlacementGroups service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribePlacementGroups service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribePlacementGroupsResult describePlacementGroups(DescribePlacementGroupsRequest describePlacementGroupsRequest) {
        ExecutionContext executionContext = createExecutionContext(describePlacementGroupsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribePlacementGroupsRequest> request = null;
        Response<DescribePlacementGroupsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribePlacementGroupsRequestMarshaller().marshall(describePlacementGroupsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribePlacementGroupsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Gives you information about your subnets. You can filter the results
     * to return information only about subnets that match criteria you
     * specify.
     * </p>
     * <p>
     * For example, you could ask to get information about a particular
     * subnet (or all) only if the subnet's state is available. You can
     * specify multiple filters (e.g., the subnet is in a particular VPC, and
     * the subnet's state is available).
     * </p>
     * <p>
     * The result includes information for a particular subnet only if the
     * subnet matches all your filters. If there's no match, no special
     * message is returned; the response is simply empty. The following table
     * shows the available filters.
     * </p>
     *
     * @param describeSubnetsRequest Container for the necessary parameters
     *           to execute the DescribeSubnets service method on AmazonEC2.
     * 
     * @return The response from the DescribeSubnets service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSubnetsResult describeSubnets(DescribeSubnetsRequest describeSubnetsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSubnetsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSubnetsRequest> request = null;
        Response<DescribeSubnetsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSubnetsRequestMarshaller().marshall(describeSubnetsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSubnetsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The RunInstances operation launches a specified number of instances.
     * </p>
     * <p>
     * If Amazon EC2 cannot launch the minimum number AMIs you request, no
     * instances launch. If there is insufficient capacity to launch the
     * maximum number of AMIs you request, Amazon EC2 launches as many as
     * possible to satisfy the requested maximum values.
     * </p>
     * <p>
     * Every instance is launched in a security group. If you do not specify
     * a security group at launch, the instances start in your default
     * security group. For more information on creating security groups, see
     * CreateSecurityGroup.
     * </p>
     * <p>
     * An optional instance type can be specified. For information about
     * instance types, see Instance Types.
     * </p>
     * <p>
     * You can provide an optional key pair ID for each image in the launch
     * request (for more information, see CreateKeyPair). All instances that
     * are created from images that use this key pair will have access to the
     * associated public key at boot. You can use this key to provide secure
     * access to an instance of an image on a per-instance basis. Amazon EC2
     * public images use this feature to provide secure access without
     * passwords.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> Launching public images without a key pair ID will
     * leave them inaccessible. The public key material is made available to
     * the instance at boot time by placing it in the openssh_id.pub file on
     * a logical device that is exposed to the instance as /dev/sda2 (the
     * ephemeral store). The format of this file is suitable for use as an
     * entry within ~/.ssh/authorized_keys (the OpenSSH format). This can be
     * done at boot (e.g., as part of rc.local) allowing for secure access
     * without passwords. Optional user data can be provided in the launch
     * request. All instances that collectively comprise the launch request
     * have access to this data For more information, see Instance Metadata.
     * </p>
     * <p>
     * <b>NOTE:</b> If any of the AMIs have a product code attached for which
     * the user has not subscribed, the RunInstances call will fail.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> We strongly recommend using the 2.6.18 Xen stock
     * kernel with the c1.medium and c1.xlarge instances. Although the
     * default Amazon EC2 kernels will work, the new kernels provide greater
     * stability and performance for these instance types. For more
     * information about kernels, see Kernels, RAM Disks, and Block Device
     * Mappings.
     * </p>
     *
     * @param runInstancesRequest Container for the necessary parameters to
     *           execute the RunInstances service method on AmazonEC2.
     * 
     * @return The response from the RunInstances service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RunInstancesResult runInstances(RunInstancesRequest runInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(runInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RunInstancesRequest> request = null;
        Response<RunInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RunInstancesRequestMarshaller().marshall(runInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new RunInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeInstances operation returns information about instances
     * that you own.
     * </p>
     * <p>
     * If you specify one or more instance IDs, Amazon EC2 returns
     * information for those instances. If you do not specify instance IDs,
     * Amazon EC2 returns information for all relevant instances. If you
     * specify an invalid instance ID, a fault is returned. If you specify an
     * instance that you do not own, it will not be included in the returned
     * results.
     * </p>
     * <p>
     * Recently terminated instances might appear in the returned results.
     * This interval is usually less than one hour.
     * </p>
     *
     * @param describeInstancesRequest Container for the necessary parameters
     *           to execute the DescribeInstances service method on AmazonEC2.
     * 
     * @return The response from the DescribeInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeInstancesResult describeInstances(DescribeInstancesRequest describeInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeInstancesRequest> request = null;
        Response<DescribeInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeInstancesRequestMarshaller().marshall(describeInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param modifyVolumeAttributeRequest Container for the necessary
     *           parameters to execute the ModifyVolumeAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void modifyVolumeAttribute(ModifyVolumeAttributeRequest modifyVolumeAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyVolumeAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyVolumeAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyVolumeAttributeRequestMarshaller().marshall(modifyVolumeAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The DescribeImages operation returns information about AMIs, AKIs,
     * and ARIs available to the user. Information returned includes image
     * type, product codes, architecture, and kernel and RAM disk IDs. Images
     * available to the user include public images available for any user to
     * launch, private images owned by the user making the request, and
     * private images owned by other users for which the user has explicit
     * launch permissions.
     * </p>
     * <p>
     * Launch permissions fall into three categories:
     * </p>
     * 
     * <ul>
     * <li> <b>Public:</b> The owner of the AMI granted launch permissions
     * for the AMI to the all group. All users have launch permissions for
     * these AMIs. </li>
     * <li> <b>Explicit:</b> The owner of the AMI granted launch permissions
     * to a specific user. </li>
     * <li> <b>Implicit:</b> A user has implicit launch permissions for all
     * AMIs he or she owns. </li>
     * 
     * </ul>
     * <p>
     * The list of AMIs returned can be modified by specifying AMI IDs, AMI
     * owners, or users with launch permissions. If no options are specified,
     * Amazon EC2 returns all AMIs for which the user has launch permissions.
     * </p>
     * <p>
     * If you specify one or more AMI IDs, only AMIs that have the specified
     * IDs are returned. If you specify an invalid AMI ID, a fault is
     * returned. If you specify an AMI ID for which you do not have access,
     * it will not be included in the returned results.
     * </p>
     * <p>
     * If you specify one or more AMI owners, only AMIs from the specified
     * owners and for which you have access are returned. The results can
     * include the account IDs of the specified owners, amazon for AMIs owned
     * by Amazon or self for AMIs that you own.
     * </p>
     * <p>
     * If you specify a list of executable users, only users that have
     * launch permissions for the AMIs are returned. You can specify account
     * IDs (if you own the AMI(s)), self for AMIs for which you own or have
     * explicit permissions, or all for public AMIs.
     * </p>
     * <p>
     * <b>NOTE:</b> Deregistered images are included in the returned results
     * for an unspecified interval after deregistration.
     * </p>
     *
     * @param describeImagesRequest Container for the necessary parameters to
     *           execute the DescribeImages service method on AmazonEC2.
     * 
     * @return The response from the DescribeImages service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeImagesResult describeImages(DescribeImagesRequest describeImagesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeImagesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeImagesRequest> request = null;
        Response<DescribeImagesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeImagesRequestMarshaller().marshall(describeImagesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeImagesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Starts an instance that uses an Amazon EBS volume as its root device.
     * Instances that use Amazon EBS volumes as their root devices can be
     * quickly stopped and started. When an instance is stopped, the compute
     * resources are released and you are not billed for hourly instance
     * usage. However, your root partition Amazon EBS volume remains,
     * continues to persist your data, and you are charged for Amazon EBS
     * volume usage. You can restart your instance at any time.
     * </p>
     * <p>
     * <b>NOTE:</b> Performing this operation on an instance that uses an
     * instance store as its root device returns an error.
     * </p>
     *
     * @param startInstancesRequest Container for the necessary parameters to
     *           execute the StartInstances service method on AmazonEC2.
     * 
     * @return The response from the StartInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public StartInstancesResult startInstances(StartInstancesRequest startInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(startInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<StartInstancesRequest> request = null;
        Response<StartInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new StartInstancesRequestMarshaller().marshall(startInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new StartInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param cancelReservedInstancesListingRequest Container for the
     *           necessary parameters to execute the CancelReservedInstancesListing
     *           service method on AmazonEC2.
     * 
     * @return The response from the CancelReservedInstancesListing service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CancelReservedInstancesListingResult cancelReservedInstancesListing(CancelReservedInstancesListingRequest cancelReservedInstancesListingRequest) {
        ExecutionContext executionContext = createExecutionContext(cancelReservedInstancesListingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CancelReservedInstancesListingRequest> request = null;
        Response<CancelReservedInstancesListingResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CancelReservedInstancesListingRequestMarshaller().marshall(cancelReservedInstancesListingRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CancelReservedInstancesListingResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Modifies an attribute of an instance.
     * </p>
     *
     * @param modifyInstanceAttributeRequest Container for the necessary
     *           parameters to execute the ModifyInstanceAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void modifyInstanceAttribute(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(modifyInstanceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifyInstanceAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifyInstanceAttributeRequestMarshaller().marshall(modifyInstanceAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The AuthorizeSecurityGroupIngress operation adds permissions to a
     * security group.
     * </p>
     * <p>
     * Permissions are specified by the IP protocol (TCP, UDP or ICMP), the
     * source of the request (by IP range or an Amazon EC2 user-group pair),
     * the source and destination port ranges (for TCP and UDP), and the ICMP
     * codes and types (for ICMP). When authorizing ICMP, <code>-1</code> can
     * be used as a wildcard in the type and code fields.
     * </p>
     * <p>
     * Permission changes are propagated to instances within the security
     * group as quickly as possible. However, depending on the number of
     * instances, a small delay might occur.
     * </p>
     *
     * @param authorizeSecurityGroupIngressRequest Container for the
     *           necessary parameters to execute the AuthorizeSecurityGroupIngress
     *           service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void authorizeSecurityGroupIngress(AuthorizeSecurityGroupIngressRequest authorizeSecurityGroupIngressRequest) {
        ExecutionContext executionContext = createExecutionContext(authorizeSecurityGroupIngressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AuthorizeSecurityGroupIngressRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AuthorizeSecurityGroupIngressRequestMarshaller().marshall(authorizeSecurityGroupIngressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Describes Spot Instance requests. Spot Instances are instances that
     * Amazon EC2 starts on your behalf when the maximum price that you
     * specify exceeds the current Spot Price. Amazon EC2 periodically sets
     * the Spot Price based on available Spot Instance capacity and current
     * spot instance requests. For conceptual information about Spot
     * Instances, refer to the <a
     * "http://docs.amazonwebservices.com/AWSEC2/2010-08-31/DeveloperGuide/">
     * Amazon Elastic Compute Cloud Developer Guide </a> or <a
     * href="http://docs.amazonwebservices.com/AWSEC2/2010-08-31/UserGuide/">
     * Amazon Elastic Compute Cloud User Guide </a> .
     * </p>
     * <p>
     * You can filter the results to return information only about Spot
     * Instance requests that match criteria you specify. For example, you
     * could get information about requests where the Spot Price you
     * specified is a certain value (you can't use greater than or less than
     * comparison, but you can use <code>*</code> and <code>?</code>
     * wildcards). You can specify multiple values for a filter. A Spot
     * Instance request must match at least one of the specified values for
     * it to be included in the results.
     * </p>
     * <p>
     * You can specify multiple filters (e.g., the Spot Price is equal to a
     * particular value, and the instance type is <code>m1.small</code> ).
     * The result includes information for a particular request only if it
     * matches all your filters. If there's no match, no special message is
     * returned; the response is simply empty.
     * </p>
     * <p>
     * You can use wildcards with the filter values: an asterisk matches
     * zero or more characters, and <code>?</code> matches exactly one
     * character. You can escape special characters using a backslash before
     * the character. For example, a value of <code>\*amazon\?\\</code>
     * searches for the literal string <code>*amazon?\</code> .
     * 
     * </p>
     *
     * @param describeSpotInstanceRequestsRequest Container for the necessary
     *           parameters to execute the DescribeSpotInstanceRequests service method
     *           on AmazonEC2.
     * 
     * @return The response from the DescribeSpotInstanceRequests service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests(DescribeSpotInstanceRequestsRequest describeSpotInstanceRequestsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSpotInstanceRequestsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSpotInstanceRequestsRequest> request = null;
        Response<DescribeSpotInstanceRequestsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSpotInstanceRequestsRequestMarshaller().marshall(describeSpotInstanceRequestsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSpotInstanceRequestsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     *
     * @param cancelExportTaskRequest Container for the necessary parameters
     *           to execute the CancelExportTask service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void cancelExportTask(CancelExportTaskRequest cancelExportTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(cancelExportTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CancelExportTaskRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CancelExportTaskRequestMarshaller().marshall(cancelExportTaskRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param copyImageRequest Container for the necessary parameters to
     *           execute the CopyImage service method on AmazonEC2.
     * 
     * @return The response from the CopyImage service method, as returned by
     *         AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CopyImageResult copyImage(CopyImageRequest copyImageRequest) {
        ExecutionContext executionContext = createExecutionContext(copyImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CopyImageRequest> request = null;
        Response<CopyImageResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CopyImageRequestMarshaller().marshall(copyImageRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CopyImageResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Creates a Spot Instance request.
     * </p>
     * <p>
     * Spot Instances are instances that Amazon EC2 starts on your behalf
     * when the maximum price that you specify exceeds the current Spot
     * Price. Amazon EC2 periodically sets the Spot Price based on available
     * Spot Instance capacity and current spot instance requests.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide.
     * </p>
     *
     * @param requestSpotInstancesRequest Container for the necessary
     *           parameters to execute the RequestSpotInstances service method on
     *           AmazonEC2.
     * 
     * @return The response from the RequestSpotInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RequestSpotInstancesResult requestSpotInstances(RequestSpotInstancesRequest requestSpotInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(requestSpotInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RequestSpotInstancesRequest> request = null;
        Response<RequestSpotInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RequestSpotInstancesRequestMarshaller().marshall(requestSpotInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new RequestSpotInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Adds or overwrites tags for the specified resources. Each resource
     * can have a maximum of 10 tags. Each tag consists of a key-value pair.
     * Tag keys must be unique per resource.
     * </p>
     *
     * @param createTagsRequest Container for the necessary parameters to
     *           execute the CreateTags service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void createTags(CreateTagsRequest createTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(createTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateTagsRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateTagsRequestMarshaller().marshall(createTagsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param describeVolumeAttributeRequest Container for the necessary
     *           parameters to execute the DescribeVolumeAttribute service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeVolumeAttribute service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVolumeAttributeResult describeVolumeAttribute(DescribeVolumeAttributeRequest describeVolumeAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(describeVolumeAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeVolumeAttributeRequest> request = null;
        Response<DescribeVolumeAttributeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeVolumeAttributeRequestMarshaller().marshall(describeVolumeAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeVolumeAttributeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes the tags for the specified resources.
     * </p>
     *
     * @param describeTagsRequest Container for the necessary parameters to
     *           execute the DescribeTags service method on AmazonEC2.
     * 
     * @return The response from the DescribeTags service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTagsResult describeTags(DescribeTagsRequest describeTagsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeTagsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeTagsRequest> request = null;
        Response<DescribeTagsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeTagsRequestMarshaller().marshall(describeTagsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeTagsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * CancelBundleTask operation cancels a pending or in-progress bundling
     * task. This is an asynchronous call and it make take a while for the
     * task to be canceled. If a task is canceled while it is storing items,
     * there may be parts of the incomplete AMI stored in S3. It is up to the
     * caller to clean up these parts from S3.
     * </p>
     *
     * @param cancelBundleTaskRequest Container for the necessary parameters
     *           to execute the CancelBundleTask service method on AmazonEC2.
     * 
     * @return The response from the CancelBundleTask service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CancelBundleTaskResult cancelBundleTask(CancelBundleTaskRequest cancelBundleTaskRequest) {
        ExecutionContext executionContext = createExecutionContext(cancelBundleTaskRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CancelBundleTaskRequest> request = null;
        Response<CancelBundleTaskResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CancelBundleTaskRequestMarshaller().marshall(cancelBundleTaskRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CancelBundleTaskResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Cancels one or more Spot Instance requests.
     * </p>
     * <p>
     * Spot Instances are instances that Amazon EC2 starts on your behalf
     * when the maximum price that you specify exceeds the current Spot
     * Price. Amazon EC2 periodically sets the Spot Price based on available
     * Spot Instance capacity and current spot instance requests.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     *
     * @param cancelSpotInstanceRequestsRequest Container for the necessary
     *           parameters to execute the CancelSpotInstanceRequests service method on
     *           AmazonEC2.
     * 
     * @return The response from the CancelSpotInstanceRequests service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CancelSpotInstanceRequestsResult cancelSpotInstanceRequests(CancelSpotInstanceRequestsRequest cancelSpotInstanceRequestsRequest) {
        ExecutionContext executionContext = createExecutionContext(cancelSpotInstanceRequestsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CancelSpotInstanceRequestsRequest> request = null;
        Response<CancelSpotInstanceRequestsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CancelSpotInstanceRequestsRequestMarshaller().marshall(cancelSpotInstanceRequestsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CancelSpotInstanceRequestsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The PurchaseReservedInstancesOffering operation purchases a Reserved
     * Instance for use with your account. With Amazon EC2 Reserved
     * Instances, you purchase the right to launch Amazon EC2 instances for a
     * period of time (without getting insufficient capacity errors) and pay
     * a lower usage rate for the actual time used.
     * </p>
     *
     * @param purchaseReservedInstancesOfferingRequest Container for the
     *           necessary parameters to execute the PurchaseReservedInstancesOffering
     *           service method on AmazonEC2.
     * 
     * @return The response from the PurchaseReservedInstancesOffering
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public PurchaseReservedInstancesOfferingResult purchaseReservedInstancesOffering(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) {
        ExecutionContext executionContext = createExecutionContext(purchaseReservedInstancesOfferingRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<PurchaseReservedInstancesOfferingRequest> request = null;
        Response<PurchaseReservedInstancesOfferingResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new PurchaseReservedInstancesOfferingRequestMarshaller().marshall(purchaseReservedInstancesOfferingRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new PurchaseReservedInstancesOfferingResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Adds or remove permission settings for the specified snapshot.
     * </p>
     *
     * @param modifySnapshotAttributeRequest Container for the necessary
     *           parameters to execute the ModifySnapshotAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void modifySnapshotAttribute(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(modifySnapshotAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ModifySnapshotAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ModifySnapshotAttributeRequestMarshaller().marshall(modifySnapshotAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The DescribeReservedInstancesModifications operation describes
     * modifications made to Reserved Instances in your account.
     * </p>
     *
     * @param describeReservedInstancesModificationsRequest Container for the
     *           necessary parameters to execute the
     *           DescribeReservedInstancesModifications service method on AmazonEC2.
     * 
     * @return The response from the DescribeReservedInstancesModifications
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesModificationsResult describeReservedInstancesModifications(DescribeReservedInstancesModificationsRequest describeReservedInstancesModificationsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesModificationsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeReservedInstancesModificationsRequest> request = null;
        Response<DescribeReservedInstancesModificationsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeReservedInstancesModificationsRequestMarshaller().marshall(describeReservedInstancesModificationsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeReservedInstancesModificationsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The TerminateInstances operation shuts down one or more instances.
     * This operation is idempotent; if you terminate an instance more than
     * once, each call will succeed.
     * </p>
     * <p>
     * Terminated instances will remain visible after termination
     * (approximately one hour).
     * </p>
     *
     * @param terminateInstancesRequest Container for the necessary
     *           parameters to execute the TerminateInstances service method on
     *           AmazonEC2.
     * 
     * @return The response from the TerminateInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public TerminateInstancesResult terminateInstances(TerminateInstancesRequest terminateInstancesRequest) {
        ExecutionContext executionContext = createExecutionContext(terminateInstancesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<TerminateInstancesRequest> request = null;
        Response<TerminateInstancesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new TerminateInstancesRequestMarshaller().marshall(terminateInstancesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new TerminateInstancesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes the data feed for Spot Instances.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     *
     * @param deleteSpotDatafeedSubscriptionRequest Container for the
     *           necessary parameters to execute the DeleteSpotDatafeedSubscription
     *           service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteSpotDatafeedSubscription(DeleteSpotDatafeedSubscriptionRequest deleteSpotDatafeedSubscriptionRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteSpotDatafeedSubscriptionRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteSpotDatafeedSubscriptionRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteSpotDatafeedSubscriptionRequestMarshaller().marshall(deleteSpotDatafeedSubscriptionRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Returns information about an attribute of a snapshot. Only one
     * attribute can be specified per call.
     * </p>
     *
     * @param describeSnapshotAttributeRequest Container for the necessary
     *           parameters to execute the DescribeSnapshotAttribute service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeSnapshotAttribute service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSnapshotAttributeResult describeSnapshotAttribute(DescribeSnapshotAttributeRequest describeSnapshotAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSnapshotAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSnapshotAttributeRequest> request = null;
        Response<DescribeSnapshotAttributeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSnapshotAttributeRequestMarshaller().marshall(describeSnapshotAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSnapshotAttributeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeAddresses operation lists elastic IP addresses assigned
     * to your account.
     * </p>
     *
     * @param describeAddressesRequest Container for the necessary parameters
     *           to execute the DescribeAddresses service method on AmazonEC2.
     * 
     * @return The response from the DescribeAddresses service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAddressesResult describeAddresses(DescribeAddressesRequest describeAddressesRequest) {
        ExecutionContext executionContext = createExecutionContext(describeAddressesRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeAddressesRequest> request = null;
        Response<DescribeAddressesResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeAddressesRequestMarshaller().marshall(describeAddressesRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeAddressesResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeImageAttribute operation returns information about an
     * attribute of an AMI. Only one attribute can be specified per call.
     * </p>
     *
     * @param describeImageAttributeRequest Container for the necessary
     *           parameters to execute the DescribeImageAttribute service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeImageAttribute service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeImageAttributeResult describeImageAttribute(DescribeImageAttributeRequest describeImageAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(describeImageAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeImageAttributeRequest> request = null;
        Response<DescribeImageAttributeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeImageAttributeRequestMarshaller().marshall(describeImageAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeImageAttributeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeKeyPairs operation returns information about key pairs
     * available to you. If you specify key pairs, information about those
     * key pairs is returned. Otherwise, information for all registered key
     * pairs is returned.
     * </p>
     *
     * @param describeKeyPairsRequest Container for the necessary parameters
     *           to execute the DescribeKeyPairs service method on AmazonEC2.
     * 
     * @return The response from the DescribeKeyPairs service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeKeyPairsResult describeKeyPairs(DescribeKeyPairsRequest describeKeyPairsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeKeyPairsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeKeyPairsRequest> request = null;
        Response<DescribeKeyPairsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeKeyPairsRequestMarshaller().marshall(describeKeyPairsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeKeyPairsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The ConfirmProductInstance operation returns true if the specified
     * product code is attached to the specified instance. The operation
     * returns false if the product code is not attached to the instance.
     * </p>
     * <p>
     * The ConfirmProductInstance operation can only be executed by the
     * owner of the AMI. This feature is useful when an AMI owner is
     * providing support and wants to verify whether a user's instance is
     * eligible.
     * </p>
     *
     * @param confirmProductInstanceRequest Container for the necessary
     *           parameters to execute the ConfirmProductInstance service method on
     *           AmazonEC2.
     * 
     * @return The response from the ConfirmProductInstance service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ConfirmProductInstanceResult confirmProductInstance(ConfirmProductInstanceRequest confirmProductInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(confirmProductInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ConfirmProductInstanceRequest> request = null;
        Response<ConfirmProductInstanceResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ConfirmProductInstanceRequestMarshaller().marshall(confirmProductInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new ConfirmProductInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Initializes an empty volume of a given size.
     * </p>
     *
     * @param createVolumeRequest Container for the necessary parameters to
     *           execute the CreateVolume service method on AmazonEC2.
     * 
     * @return The response from the CreateVolume service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateVolumeResult createVolume(CreateVolumeRequest createVolumeRequest) {
        ExecutionContext executionContext = createExecutionContext(createVolumeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateVolumeRequest> request = null;
        Response<CreateVolumeResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateVolumeRequestMarshaller().marshall(createVolumeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateVolumeResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Describes the status of an Amazon Elastic Compute Cloud (Amazon EC2)
     * instance. Instance status provides information about two types of
     * scheduled events for an instance that may require your attention:
     * </p>
     * 
     * <ul>
     * <li> Scheduled Reboot: When Amazon EC2 determines that an instance
     * must be rebooted, the instance's status will return one of two event
     * codes: <code>system-reboot</code> or <code>instance-reboot</code> .
     * System reboot commonly occurs if certain maintenance or upgrade
     * operations require a reboot of the underlying host that supports an
     * instance. Instance reboot commonly occurs if the instance must be
     * rebooted, rather than the underlying host. Rebooting events include a
     * scheduled start and end time. </li>
     * <li> Scheduled Retirement: When Amazon EC2 determines that an
     * instance must be shut down, the instance's status will return an event
     * code called <code>instance-retirement</code> . Retirement commonly
     * occurs when the underlying host is degraded and must be replaced.
     * Retirement events include a scheduled start and end time. You're also
     * notified by email if one of your instances is set to retiring. The
     * email message indicates when your instance will be permanently
     * retired. </li>
     * 
     * </ul>
     * <p>
     * If your instance is permanently retired, it will not be restarted.
     * You can avoid retirement by manually restarting your instance when its
     * event code is <code>instance-retirement</code> . This ensures that
     * your instance is started on a healthy host.
     * </p>
     * <p>
     * <code>DescribeInstanceStatus</code> returns information only for
     * instances in the running state.
     * </p>
     * <p>
     * You can filter the results to return information only about instances
     * that match criteria you specify. For example, you could get
     * information about instances in a specific Availability Zone. You can
     * specify multiple values for a filter (e.g., more than one Availability
     * Zone). An instance must match at least one of the specified values for
     * it to be included in the results.
     * </p>
     * <p>
     * You can specify multiple filters. An instance must match all the
     * filters for it to be included in the results. If there's no match, no
     * special message is returned; the response is simply empty.
     * </p>
     * <p>
     * You can use wildcards with the filter values: <code>*</code> matches
     * zero or more characters, and <code>?</code> matches exactly one
     * character. You can escape special characters using a backslash before
     * the character. For example, a value of <code>\*amazon\?\\</code>
     * searches for the literal string <code>*amazon?\</code> .
     * 
     * </p>
     * <p>
     * The following filters are available:
     * </p>
     * 
     * <ul>
     * <li> <code>availability-zone</code> - Filter on an instance's
     * availability zone. </li>
     * <li> <code>instance-state-name</code> - Filter on the intended state
     * of the instance, e.g., running. </li>
     * <li> <code>instance-state-code</code> - Filter on the intended state
     * code of the instance, e.g., 16. </li>
     * 
     * </ul>
     *
     * @param describeInstanceStatusRequest Container for the necessary
     *           parameters to execute the DescribeInstanceStatus service method on
     *           AmazonEC2.
     * 
     * @return The response from the DescribeInstanceStatus service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeInstanceStatusResult describeInstanceStatus(DescribeInstanceStatusRequest describeInstanceStatusRequest) {
        ExecutionContext executionContext = createExecutionContext(describeInstanceStatusRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeInstanceStatusRequest> request = null;
        Response<DescribeInstanceStatusResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeInstanceStatusRequestMarshaller().marshall(describeInstanceStatusRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeInstanceStatusResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeReservedInstancesOfferings operation describes Reserved
     * Instance offerings that are available for purchase. With Amazon EC2
     * Reserved Instances, you purchase the right to launch Amazon EC2
     * instances for a period of time (without getting insufficient capacity
     * errors) and pay a lower usage rate for the actual time used.
     * </p>
     *
     * @param describeReservedInstancesOfferingsRequest Container for the
     *           necessary parameters to execute the DescribeReservedInstancesOfferings
     *           service method on AmazonEC2.
     * 
     * @return The response from the DescribeReservedInstancesOfferings
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings(DescribeReservedInstancesOfferingsRequest describeReservedInstancesOfferingsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeReservedInstancesOfferingsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeReservedInstancesOfferingsRequest> request = null;
        Response<DescribeReservedInstancesOfferingsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeReservedInstancesOfferingsRequestMarshaller().marshall(describeReservedInstancesOfferingsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeReservedInstancesOfferingsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes the snapshot identified by <code>snapshotId</code> .
     * 
     * </p>
     *
     * @param deleteSnapshotRequest Container for the necessary parameters to
     *           execute the DeleteSnapshot service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteSnapshot(DeleteSnapshotRequest deleteSnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(deleteSnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeleteSnapshotRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeleteSnapshotRequestMarshaller().marshall(deleteSnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The DisassociateAddress operation disassociates the specified elastic
     * IP address from the instance to which it is assigned. This is an
     * idempotent operation. If you enter it more than once, Amazon EC2 does
     * not return an error.
     * </p>
     *
     * @param disassociateAddressRequest Container for the necessary
     *           parameters to execute the DisassociateAddress service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void disassociateAddress(DisassociateAddressRequest disassociateAddressRequest) {
        ExecutionContext executionContext = createExecutionContext(disassociateAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DisassociateAddressRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DisassociateAddressRequestMarshaller().marshall(disassociateAddressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Creates a PlacementGroup into which multiple Amazon EC2 instances can
     * be launched. Users must give the group a name unique within the scope
     * of the user account.
     * </p>
     *
     * @param createPlacementGroupRequest Container for the necessary
     *           parameters to execute the CreatePlacementGroup service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void createPlacementGroup(CreatePlacementGroupRequest createPlacementGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(createPlacementGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreatePlacementGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreatePlacementGroupRequestMarshaller().marshall(createPlacementGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The BundleInstance operation request that an instance is bundled the
     * next time it boots. The bundling process creates a new image from a
     * running instance and stores the AMI data in S3. Once bundled, the
     * image must be registered in the normal way using the RegisterImage
     * API.
     * </p>
     *
     * @param bundleInstanceRequest Container for the necessary parameters to
     *           execute the BundleInstance service method on AmazonEC2.
     * 
     * @return The response from the BundleInstance service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public BundleInstanceResult bundleInstance(BundleInstanceRequest bundleInstanceRequest) {
        ExecutionContext executionContext = createExecutionContext(bundleInstanceRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<BundleInstanceRequest> request = null;
        Response<BundleInstanceResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new BundleInstanceRequestMarshaller().marshall(bundleInstanceRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new BundleInstanceResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Deletes a PlacementGroup from a user's account. Terminate all Amazon
     * EC2 instances in the placement group before deletion.
     * </p>
     *
     * @param deletePlacementGroupRequest Container for the necessary
     *           parameters to execute the DeletePlacementGroup service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deletePlacementGroup(DeletePlacementGroupRequest deletePlacementGroupRequest) {
        ExecutionContext executionContext = createExecutionContext(deletePlacementGroupRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DeletePlacementGroupRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DeletePlacementGroupRequestMarshaller().marshall(deletePlacementGroupRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     *
     * @param copySnapshotRequest Container for the necessary parameters to
     *           execute the CopySnapshot service method on AmazonEC2.
     * 
     * @return The response from the CopySnapshot service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CopySnapshotResult copySnapshot(CopySnapshotRequest copySnapshotRequest) {
        ExecutionContext executionContext = createExecutionContext(copySnapshotRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CopySnapshotRequest> request = null;
        Response<CopySnapshotResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CopySnapshotRequestMarshaller().marshall(copySnapshotRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CopySnapshotResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The AllocateAddress operation acquires an elastic IP address for use
     * with your account.
     * </p>
     *
     * @param allocateAddressRequest Container for the necessary parameters
     *           to execute the AllocateAddress service method on AmazonEC2.
     * 
     * @return The response from the AllocateAddress service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AllocateAddressResult allocateAddress(AllocateAddressRequest allocateAddressRequest) {
        ExecutionContext executionContext = createExecutionContext(allocateAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<AllocateAddressRequest> request = null;
        Response<AllocateAddressResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new AllocateAddressRequestMarshaller().marshall(allocateAddressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new AllocateAddressResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The ReleaseAddress operation releases an elastic IP address
     * associated with your account.
     * </p>
     * <p>
     * <b>NOTE:</b> Releasing an IP address automatically disassociates it
     * from any instance with which it is associated. For more information,
     * see DisassociateAddress.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> After releasing an elastic IP address, it is
     * released to the IP address pool and might no longer be available to
     * your account. Make sure to update your DNS records and any servers or
     * devices that communicate with the address. If you run this operation
     * on an elastic IP address that is already released, the address might
     * be assigned to another account which will cause Amazon EC2 to return
     * an error.
     * </p>
     *
     * @param releaseAddressRequest Container for the necessary parameters to
     *           execute the ReleaseAddress service method on AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void releaseAddress(ReleaseAddressRequest releaseAddressRequest) {
        ExecutionContext executionContext = createExecutionContext(releaseAddressRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ReleaseAddressRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ReleaseAddressRequestMarshaller().marshall(releaseAddressRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * Resets an attribute of an instance to its default value.
     * </p>
     *
     * @param resetInstanceAttributeRequest Container for the necessary
     *           parameters to execute the ResetInstanceAttribute service method on
     *           AmazonEC2.
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void resetInstanceAttribute(ResetInstanceAttributeRequest resetInstanceAttributeRequest) {
        ExecutionContext executionContext = createExecutionContext(resetInstanceAttributeRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<ResetInstanceAttributeRequest> request = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new ResetInstanceAttributeRequestMarshaller().marshall(resetInstanceAttributeRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            invoke(request, null, executionContext);
        } finally {
            endClientExecution(awsRequestMetrics, request, null);
        }
    }
    
    /**
     * <p>
     * The CreateKeyPair operation creates a new 2048 bit RSA key pair and
     * returns a unique ID that can be used to reference this key pair when
     * launching new instances. For more information, see RunInstances.
     * </p>
     *
     * @param createKeyPairRequest Container for the necessary parameters to
     *           execute the CreateKeyPair service method on AmazonEC2.
     * 
     * @return The response from the CreateKeyPair service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public CreateKeyPairResult createKeyPair(CreateKeyPairRequest createKeyPairRequest) {
        ExecutionContext executionContext = createExecutionContext(createKeyPairRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<CreateKeyPairRequest> request = null;
        Response<CreateKeyPairResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new CreateKeyPairRequestMarshaller().marshall(createKeyPairRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new CreateKeyPairResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * Returns information about the Amazon EBS snapshots available to you.
     * Snapshots available to you include public snapshots available for any
     * AWS account to launch, private snapshots you own, and private
     * snapshots owned by another AWS account but for which you've been given
     * explicit create volume permissions.
     * </p>
     *
     * @param describeSnapshotsRequest Container for the necessary parameters
     *           to execute the DescribeSnapshots service method on AmazonEC2.
     * 
     * @return The response from the DescribeSnapshots service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSnapshotsResult describeSnapshots(DescribeSnapshotsRequest describeSnapshotsRequest) {
        ExecutionContext executionContext = createExecutionContext(describeSnapshotsRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<DescribeSnapshotsRequest> request = null;
        Response<DescribeSnapshotsResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new DescribeSnapshotsRequestMarshaller().marshall(describeSnapshotsRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new DescribeSnapshotsResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The RegisterImage operation registers an AMI with Amazon EC2. Images
     * must be registered before they can be launched. For more information,
     * see RunInstances.
     * </p>
     * <p>
     * Each AMI is associated with an unique ID which is provided by the
     * Amazon EC2 service through the RegisterImage operation. During
     * registration, Amazon EC2 retrieves the specified image manifest from
     * Amazon S3 and verifies that the image is owned by the user registering
     * the image.
     * </p>
     * <p>
     * The image manifest is retrieved once and stored within the Amazon
     * EC2. Any modifications to an image in Amazon S3 invalidates this
     * registration. If you make changes to an image, deregister the previous
     * image and register the new image. For more information, see
     * DeregisterImage.
     * </p>
     *
     * @param registerImageRequest Container for the necessary parameters to
     *           execute the RegisterImage service method on AmazonEC2.
     * 
     * @return The response from the RegisterImage service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RegisterImageResult registerImage(RegisterImageRequest registerImageRequest) {
        ExecutionContext executionContext = createExecutionContext(registerImageRequest);
        AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
        Request<RegisterImageRequest> request = null;
        Response<RegisterImageResult> response = null;
        awsRequestMetrics.startEvent(Field.ClientExecuteTime);
        try {
            request = new RegisterImageRequestMarshaller().marshall(registerImageRequest);
            // Binds the request metrics to the current request.
            request.setAWSRequestMetrics(awsRequestMetrics);
            response = invoke(request, new RegisterImageResultStaxUnmarshaller(), executionContext);
            return response.getAwsResponse();
        } finally {
            endClientExecution(awsRequestMetrics, request, response);
        }
    }
    
    /**
     * <p>
     * The DescribeReservedInstances operation describes Reserved Instances
     * that were purchased for use with your account.
     * </p>
     * 
     * @return The response from the DescribeReservedInstances service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesResult describeReservedInstances() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstances(new DescribeReservedInstancesRequest());
    }
    
    /**
     * <p>
     * The DescribeAvailabilityZones operation describes availability zones
     * that are currently available to the account and their states.
     * </p>
     * <p>
     * Availability zones are not the same across accounts. The availability
     * zone <code>us-east-1a</code> for account A is not necessarily the same
     * as <code>us-east-1a</code> for account B. Zone assignments are mapped
     * independently for each account.
     * </p>
     * 
     * @return The response from the DescribeAvailabilityZones service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAvailabilityZonesResult describeAvailabilityZones() throws AmazonServiceException, AmazonClientException {
        return describeAvailabilityZones(new DescribeAvailabilityZonesRequest());
    }
    
    /**
     * <p>
     * The DeleteSecurityGroup operation deletes a security group.
     * </p>
     * <p>
     * <b>NOTE:</b> If you attempt to delete a security group that contains
     * instances, a fault is returned. If you attempt to delete a security
     * group that is referenced by another security group, a fault is
     * returned. For example, if security group B has a rule that allows
     * access from security group A, security group A cannot be deleted until
     * the allow rule is removed.
     * </p>
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteSecurityGroup() throws AmazonServiceException, AmazonClientException {
        deleteSecurityGroup(new DeleteSecurityGroupRequest());
    }
    
    /**
     * <p>
     * Describes the Spot Price history.
     * </p>
     * <p>
     * Spot Instances are instances that Amazon EC2 starts on your behalf
     * when the maximum price that you specify exceeds the current Spot
     * Price. Amazon EC2 periodically sets the Spot Price based on available
     * Spot Instance capacity and current spot instance requests.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     * 
     * @return The response from the DescribeSpotPriceHistory service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSpotPriceHistoryResult describeSpotPriceHistory() throws AmazonServiceException, AmazonClientException {
        return describeSpotPriceHistory(new DescribeSpotPriceHistoryRequest());
    }
    
    /**
     * <p>
     * The DescribeRegions operation describes regions zones that are
     * currently available to the account.
     * </p>
     * 
     * @return The response from the DescribeRegions service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeRegionsResult describeRegions() throws AmazonServiceException, AmazonClientException {
        return describeRegions(new DescribeRegionsRequest());
    }
    
    /**
     * 
     * @return The response from the ImportVolume service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public ImportVolumeResult importVolume() throws AmazonServiceException, AmazonClientException {
        return importVolume(new ImportVolumeRequest());
    }
    
    /**
     * <p>
     * The DescribeSecurityGroups operation returns information about
     * security groups that you own.
     * </p>
     * <p>
     * If you specify security group names, information about those security
     * group is returned. Otherwise, information for all security group is
     * returned. If you specify a group that does not exist, a fault is
     * returned.
     * </p>
     * 
     * @return The response from the DescribeSecurityGroups service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSecurityGroupsResult describeSecurityGroups() throws AmazonServiceException, AmazonClientException {
        return describeSecurityGroups(new DescribeSecurityGroupsRequest());
    }
    
    /**
     * <p>
     * Describes the data feed for Spot Instances.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     * 
     * @return The response from the DescribeSpotDatafeedSubscription service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscription() throws AmazonServiceException, AmazonClientException {
        return describeSpotDatafeedSubscription(new DescribeSpotDatafeedSubscriptionRequest());
    }
    
    /**
     * 
     * @return The response from the DescribeAccountAttributes service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAccountAttributesResult describeAccountAttributes() throws AmazonServiceException, AmazonClientException {
        return describeAccountAttributes(new DescribeAccountAttributesRequest());
    }
    
    /**
     * <p>
     * Provides details of a user's registered licenses. Zero or more IDs
     * may be specified on the call. When one or more license IDs are
     * specified, only data for the specified IDs are returned.
     * </p>
     * 
     * @return The response from the DescribeLicenses service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeLicensesResult describeLicenses() throws AmazonServiceException, AmazonClientException {
        return describeLicenses(new DescribeLicensesRequest());
    }
    
    /**
     * <p>
     * Describes the status of a volume.
     * </p>
     * 
     * @return The response from the DescribeVolumeStatus service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVolumeStatusResult describeVolumeStatus() throws AmazonServiceException, AmazonClientException {
        return describeVolumeStatus(new DescribeVolumeStatusRequest());
    }
    
    /**
     * <p>
     * Gives you information about your VPCs. You can filter the results to
     * return information only about VPCs that match criteria you specify.
     * </p>
     * <p>
     * For example, you could ask to get information about a particular VPC
     * or VPCs (or all your VPCs) only if the VPC's state is available. You
     * can specify multiple filters (e.g., the VPC uses one of several sets
     * of DHCP options, and the VPC's state is available). The result
     * includes information for a particular VPC only if the VPC matches all
     * your filters.
     * </p>
     * <p>
     * If there's no match, no special message is returned; the response is
     * simply empty. The following table shows the available filters.
     * </p>
     * 
     * @return The response from the DescribeVpcs service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVpcsResult describeVpcs() throws AmazonServiceException, AmazonClientException {
        return describeVpcs(new DescribeVpcsRequest());
    }
    
    /**
     * 
     * @return The response from the DescribeExportTasks service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeExportTasksResult describeExportTasks() throws AmazonServiceException, AmazonClientException {
        return describeExportTasks(new DescribeExportTasksRequest());
    }
    
    /**
     * <p>
     * Describes the status of the indicated volume or, in lieu of any
     * specified, all volumes belonging to the caller. Volumes that have been
     * deleted are not described.
     * </p>
     * 
     * @return The response from the DescribeVolumes service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeVolumesResult describeVolumes() throws AmazonServiceException, AmazonClientException {
        return describeVolumes(new DescribeVolumesRequest());
    }
    
    /**
     * 
     * @return The response from the DescribeReservedInstancesListings
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesListingsResult describeReservedInstancesListings() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstancesListings(new DescribeReservedInstancesListingsRequest());
    }
    
    /**
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void reportInstanceStatus() throws AmazonServiceException, AmazonClientException {
        reportInstanceStatus(new ReportInstanceStatusRequest());
    }
    
    /**
     * <p>
     * The DescribeBundleTasks operation describes in-progress and recent
     * bundle tasks. Complete and failed tasks are removed from the list a
     * short time after completion. If no bundle ids are given, all bundle
     * tasks are returned.
     * </p>
     * 
     * @return The response from the DescribeBundleTasks service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeBundleTasksResult describeBundleTasks() throws AmazonServiceException, AmazonClientException {
        return describeBundleTasks(new DescribeBundleTasksRequest());
    }
    
    /**
     * <p>
     * The RevokeSecurityGroupIngress operation revokes permissions from a
     * security group. The permissions used to revoke must be specified using
     * the same values used to grant the permissions.
     * </p>
     * <p>
     * Permissions are specified by IP protocol (TCP, UDP, or ICMP), the
     * source of the request (by IP range or an Amazon EC2 user-group pair),
     * the source and destination port ranges (for TCP and UDP), and the ICMP
     * codes and types (for ICMP).
     * </p>
     * <p>
     * Permission changes are quickly propagated to instances within the
     * security group. However, depending on the number of instances in the
     * group, a small delay might occur.
     * </p>
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void revokeSecurityGroupIngress() throws AmazonServiceException, AmazonClientException {
        revokeSecurityGroupIngress(new RevokeSecurityGroupIngressRequest());
    }
    
    /**
     * 
     * @return The response from the DescribeConversionTasks service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeConversionTasksResult describeConversionTasks() throws AmazonServiceException, AmazonClientException {
        return describeConversionTasks(new DescribeConversionTasksRequest());
    }
    
    /**
     * <p>
     * Returns information about one or more PlacementGroup instances in a
     * user's account.
     * </p>
     * 
     * @return The response from the DescribePlacementGroups service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribePlacementGroupsResult describePlacementGroups() throws AmazonServiceException, AmazonClientException {
        return describePlacementGroups(new DescribePlacementGroupsRequest());
    }
    
    /**
     * <p>
     * Gives you information about your subnets. You can filter the results
     * to return information only about subnets that match criteria you
     * specify.
     * </p>
     * <p>
     * For example, you could ask to get information about a particular
     * subnet (or all) only if the subnet's state is available. You can
     * specify multiple filters (e.g., the subnet is in a particular VPC, and
     * the subnet's state is available).
     * </p>
     * <p>
     * The result includes information for a particular subnet only if the
     * subnet matches all your filters. If there's no match, no special
     * message is returned; the response is simply empty. The following table
     * shows the available filters.
     * </p>
     * 
     * @return The response from the DescribeSubnets service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSubnetsResult describeSubnets() throws AmazonServiceException, AmazonClientException {
        return describeSubnets(new DescribeSubnetsRequest());
    }
    
    /**
     * <p>
     * The DescribeInstances operation returns information about instances
     * that you own.
     * </p>
     * <p>
     * If you specify one or more instance IDs, Amazon EC2 returns
     * information for those instances. If you do not specify instance IDs,
     * Amazon EC2 returns information for all relevant instances. If you
     * specify an invalid instance ID, a fault is returned. If you specify an
     * instance that you do not own, it will not be included in the returned
     * results.
     * </p>
     * <p>
     * Recently terminated instances might appear in the returned results.
     * This interval is usually less than one hour.
     * </p>
     * 
     * @return The response from the DescribeInstances service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeInstancesResult describeInstances() throws AmazonServiceException, AmazonClientException {
        return describeInstances(new DescribeInstancesRequest());
    }
    
    /**
     * <p>
     * The DescribeImages operation returns information about AMIs, AKIs,
     * and ARIs available to the user. Information returned includes image
     * type, product codes, architecture, and kernel and RAM disk IDs. Images
     * available to the user include public images available for any user to
     * launch, private images owned by the user making the request, and
     * private images owned by other users for which the user has explicit
     * launch permissions.
     * </p>
     * <p>
     * Launch permissions fall into three categories:
     * </p>
     * 
     * <ul>
     * <li> <b>Public:</b> The owner of the AMI granted launch permissions
     * for the AMI to the all group. All users have launch permissions for
     * these AMIs. </li>
     * <li> <b>Explicit:</b> The owner of the AMI granted launch permissions
     * to a specific user. </li>
     * <li> <b>Implicit:</b> A user has implicit launch permissions for all
     * AMIs he or she owns. </li>
     * 
     * </ul>
     * <p>
     * The list of AMIs returned can be modified by specifying AMI IDs, AMI
     * owners, or users with launch permissions. If no options are specified,
     * Amazon EC2 returns all AMIs for which the user has launch permissions.
     * </p>
     * <p>
     * If you specify one or more AMI IDs, only AMIs that have the specified
     * IDs are returned. If you specify an invalid AMI ID, a fault is
     * returned. If you specify an AMI ID for which you do not have access,
     * it will not be included in the returned results.
     * </p>
     * <p>
     * If you specify one or more AMI owners, only AMIs from the specified
     * owners and for which you have access are returned. The results can
     * include the account IDs of the specified owners, amazon for AMIs owned
     * by Amazon or self for AMIs that you own.
     * </p>
     * <p>
     * If you specify a list of executable users, only users that have
     * launch permissions for the AMIs are returned. You can specify account
     * IDs (if you own the AMI(s)), self for AMIs for which you own or have
     * explicit permissions, or all for public AMIs.
     * </p>
     * <p>
     * <b>NOTE:</b> Deregistered images are included in the returned results
     * for an unspecified interval after deregistration.
     * </p>
     * 
     * @return The response from the DescribeImages service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeImagesResult describeImages() throws AmazonServiceException, AmazonClientException {
        return describeImages(new DescribeImagesRequest());
    }
    
    /**
     * <p>
     * The AuthorizeSecurityGroupIngress operation adds permissions to a
     * security group.
     * </p>
     * <p>
     * Permissions are specified by the IP protocol (TCP, UDP or ICMP), the
     * source of the request (by IP range or an Amazon EC2 user-group pair),
     * the source and destination port ranges (for TCP and UDP), and the ICMP
     * codes and types (for ICMP). When authorizing ICMP, <code>-1</code> can
     * be used as a wildcard in the type and code fields.
     * </p>
     * <p>
     * Permission changes are propagated to instances within the security
     * group as quickly as possible. However, depending on the number of
     * instances, a small delay might occur.
     * </p>
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void authorizeSecurityGroupIngress() throws AmazonServiceException, AmazonClientException {
        authorizeSecurityGroupIngress(new AuthorizeSecurityGroupIngressRequest());
    }
    
    /**
     * <p>
     * Describes Spot Instance requests. Spot Instances are instances that
     * Amazon EC2 starts on your behalf when the maximum price that you
     * specify exceeds the current Spot Price. Amazon EC2 periodically sets
     * the Spot Price based on available Spot Instance capacity and current
     * spot instance requests. For conceptual information about Spot
     * Instances, refer to the <a
     * "http://docs.amazonwebservices.com/AWSEC2/2010-08-31/DeveloperGuide/">
     * Amazon Elastic Compute Cloud Developer Guide </a> or <a
     * href="http://docs.amazonwebservices.com/AWSEC2/2010-08-31/UserGuide/">
     * Amazon Elastic Compute Cloud User Guide </a> .
     * </p>
     * <p>
     * You can filter the results to return information only about Spot
     * Instance requests that match criteria you specify. For example, you
     * could get information about requests where the Spot Price you
     * specified is a certain value (you can't use greater than or less than
     * comparison, but you can use <code>*</code> and <code>?</code>
     * wildcards). You can specify multiple values for a filter. A Spot
     * Instance request must match at least one of the specified values for
     * it to be included in the results.
     * </p>
     * <p>
     * You can specify multiple filters (e.g., the Spot Price is equal to a
     * particular value, and the instance type is <code>m1.small</code> ).
     * The result includes information for a particular request only if it
     * matches all your filters. If there's no match, no special message is
     * returned; the response is simply empty.
     * </p>
     * <p>
     * You can use wildcards with the filter values: an asterisk matches
     * zero or more characters, and <code>?</code> matches exactly one
     * character. You can escape special characters using a backslash before
     * the character. For example, a value of <code>\*amazon\?\\</code>
     * searches for the literal string <code>*amazon?\</code> .
     * 
     * </p>
     * 
     * @return The response from the DescribeSpotInstanceRequests service
     *         method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSpotInstanceRequestsResult describeSpotInstanceRequests() throws AmazonServiceException, AmazonClientException {
        return describeSpotInstanceRequests(new DescribeSpotInstanceRequestsRequest());
    }
    
    /**
     * <p>
     * Describes the tags for the specified resources.
     * </p>
     * 
     * @return The response from the DescribeTags service method, as returned
     *         by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeTagsResult describeTags() throws AmazonServiceException, AmazonClientException {
        return describeTags(new DescribeTagsRequest());
    }
    
    /**
     * <p>
     * The DescribeReservedInstancesModifications operation describes
     * modifications made to Reserved Instances in your account.
     * </p>
     * 
     * @return The response from the DescribeReservedInstancesModifications
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesModificationsResult describeReservedInstancesModifications() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstancesModifications(new DescribeReservedInstancesModificationsRequest());
    }
    
    /**
     * <p>
     * Deletes the data feed for Spot Instances.
     * </p>
     * <p>
     * For conceptual information about Spot Instances, refer to the Amazon
     * Elastic Compute Cloud Developer Guide or Amazon Elastic Compute Cloud
     * User Guide .
     * 
     * </p>
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void deleteSpotDatafeedSubscription() throws AmazonServiceException, AmazonClientException {
        deleteSpotDatafeedSubscription(new DeleteSpotDatafeedSubscriptionRequest());
    }
    
    /**
     * <p>
     * The DescribeAddresses operation lists elastic IP addresses assigned
     * to your account.
     * </p>
     * 
     * @return The response from the DescribeAddresses service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeAddressesResult describeAddresses() throws AmazonServiceException, AmazonClientException {
        return describeAddresses(new DescribeAddressesRequest());
    }
    
    /**
     * <p>
     * The DescribeKeyPairs operation returns information about key pairs
     * available to you. If you specify key pairs, information about those
     * key pairs is returned. Otherwise, information for all registered key
     * pairs is returned.
     * </p>
     * 
     * @return The response from the DescribeKeyPairs service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeKeyPairsResult describeKeyPairs() throws AmazonServiceException, AmazonClientException {
        return describeKeyPairs(new DescribeKeyPairsRequest());
    }
    
    /**
     * <p>
     * Describes the status of an Amazon Elastic Compute Cloud (Amazon EC2)
     * instance. Instance status provides information about two types of
     * scheduled events for an instance that may require your attention:
     * </p>
     * 
     * <ul>
     * <li> Scheduled Reboot: When Amazon EC2 determines that an instance
     * must be rebooted, the instance's status will return one of two event
     * codes: <code>system-reboot</code> or <code>instance-reboot</code> .
     * System reboot commonly occurs if certain maintenance or upgrade
     * operations require a reboot of the underlying host that supports an
     * instance. Instance reboot commonly occurs if the instance must be
     * rebooted, rather than the underlying host. Rebooting events include a
     * scheduled start and end time. </li>
     * <li> Scheduled Retirement: When Amazon EC2 determines that an
     * instance must be shut down, the instance's status will return an event
     * code called <code>instance-retirement</code> . Retirement commonly
     * occurs when the underlying host is degraded and must be replaced.
     * Retirement events include a scheduled start and end time. You're also
     * notified by email if one of your instances is set to retiring. The
     * email message indicates when your instance will be permanently
     * retired. </li>
     * 
     * </ul>
     * <p>
     * If your instance is permanently retired, it will not be restarted.
     * You can avoid retirement by manually restarting your instance when its
     * event code is <code>instance-retirement</code> . This ensures that
     * your instance is started on a healthy host.
     * </p>
     * <p>
     * <code>DescribeInstanceStatus</code> returns information only for
     * instances in the running state.
     * </p>
     * <p>
     * You can filter the results to return information only about instances
     * that match criteria you specify. For example, you could get
     * information about instances in a specific Availability Zone. You can
     * specify multiple values for a filter (e.g., more than one Availability
     * Zone). An instance must match at least one of the specified values for
     * it to be included in the results.
     * </p>
     * <p>
     * You can specify multiple filters. An instance must match all the
     * filters for it to be included in the results. If there's no match, no
     * special message is returned; the response is simply empty.
     * </p>
     * <p>
     * You can use wildcards with the filter values: <code>*</code> matches
     * zero or more characters, and <code>?</code> matches exactly one
     * character. You can escape special characters using a backslash before
     * the character. For example, a value of <code>\*amazon\?\\</code>
     * searches for the literal string <code>*amazon?\</code> .
     * 
     * </p>
     * <p>
     * The following filters are available:
     * </p>
     * 
     * <ul>
     * <li> <code>availability-zone</code> - Filter on an instance's
     * availability zone. </li>
     * <li> <code>instance-state-name</code> - Filter on the intended state
     * of the instance, e.g., running. </li>
     * <li> <code>instance-state-code</code> - Filter on the intended state
     * code of the instance, e.g., 16. </li>
     * 
     * </ul>
     * 
     * @return The response from the DescribeInstanceStatus service method,
     *         as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeInstanceStatusResult describeInstanceStatus() throws AmazonServiceException, AmazonClientException {
        return describeInstanceStatus(new DescribeInstanceStatusRequest());
    }
    
    /**
     * <p>
     * The DescribeReservedInstancesOfferings operation describes Reserved
     * Instance offerings that are available for purchase. With Amazon EC2
     * Reserved Instances, you purchase the right to launch Amazon EC2
     * instances for a period of time (without getting insufficient capacity
     * errors) and pay a lower usage rate for the actual time used.
     * </p>
     * 
     * @return The response from the DescribeReservedInstancesOfferings
     *         service method, as returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeReservedInstancesOfferingsResult describeReservedInstancesOfferings() throws AmazonServiceException, AmazonClientException {
        return describeReservedInstancesOfferings(new DescribeReservedInstancesOfferingsRequest());
    }
    
    /**
     * <p>
     * The DisassociateAddress operation disassociates the specified elastic
     * IP address from the instance to which it is assigned. This is an
     * idempotent operation. If you enter it more than once, Amazon EC2 does
     * not return an error.
     * </p>
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void disassociateAddress() throws AmazonServiceException, AmazonClientException {
        disassociateAddress(new DisassociateAddressRequest());
    }
    
    /**
     * <p>
     * The AllocateAddress operation acquires an elastic IP address for use
     * with your account.
     * </p>
     * 
     * @return The response from the AllocateAddress service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public AllocateAddressResult allocateAddress() throws AmazonServiceException, AmazonClientException {
        return allocateAddress(new AllocateAddressRequest());
    }
    
    /**
     * <p>
     * The ReleaseAddress operation releases an elastic IP address
     * associated with your account.
     * </p>
     * <p>
     * <b>NOTE:</b> Releasing an IP address automatically disassociates it
     * from any instance with which it is associated. For more information,
     * see DisassociateAddress.
     * </p>
     * <p>
     * <b>IMPORTANT:</b> After releasing an elastic IP address, it is
     * released to the IP address pool and might no longer be available to
     * your account. Make sure to update your DNS records and any servers or
     * devices that communicate with the address. If you run this operation
     * on an elastic IP address that is already released, the address might
     * be assigned to another account which will cause Amazon EC2 to return
     * an error.
     * </p>
     * 
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public void releaseAddress() throws AmazonServiceException, AmazonClientException {
        releaseAddress(new ReleaseAddressRequest());
    }
    
    /**
     * <p>
     * Returns information about the Amazon EBS snapshots available to you.
     * Snapshots available to you include public snapshots available for any
     * AWS account to launch, private snapshots you own, and private
     * snapshots owned by another AWS account but for which you've been given
     * explicit create volume permissions.
     * </p>
     * 
     * @return The response from the DescribeSnapshots service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public DescribeSnapshotsResult describeSnapshots() throws AmazonServiceException, AmazonClientException {
        return describeSnapshots(new DescribeSnapshotsRequest());
    }
    
    /**
     * <p>
     * The RegisterImage operation registers an AMI with Amazon EC2. Images
     * must be registered before they can be launched. For more information,
     * see RunInstances.
     * </p>
     * <p>
     * Each AMI is associated with an unique ID which is provided by the
     * Amazon EC2 service through the RegisterImage operation. During
     * registration, Amazon EC2 retrieves the specified image manifest from
     * Amazon S3 and verifies that the image is owned by the user registering
     * the image.
     * </p>
     * <p>
     * The image manifest is retrieved once and stored within the Amazon
     * EC2. Any modifications to an image in Amazon S3 invalidates this
     * registration. If you make changes to an image, deregister the previous
     * image and register the new image. For more information, see
     * DeregisterImage.
     * </p>
     * 
     * @return The response from the RegisterImage service method, as
     *         returned by AmazonEC2.
     * 
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client while
     *             attempting to make the request or handle the response.  For example
     *             if a network connection is not available.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server side issue.
     */
    public RegisterImageResult registerImage() throws AmazonServiceException, AmazonClientException {
        return registerImage(new RegisterImageRequest());
    }
    
    /**
     * Checks whether you have the required permissions for the provided
     * AmazonEC2 operation, without actually running it. The returned
     * DryRunResult object contains the information of whether the dry-run was
     * successful. This method will throw exception when the service response
     * does not clearly indicate whether you have the permission.
     *
     * @param request
     *            The request object for any AmazonEC2 operation supported with
     *            dry-run.
     *
     * @return A DryRunResult object that contains the information of whether
     *         the dry-run was successful.
     *
     * @throws AmazonClientException
     *             If any internal errors are encountered inside the client
     *             while attempting to make the request or handle the response.
     *             Or if the service response does not clearly indicate whether
     *             you have the permission.
     * @throws AmazonServiceException
     *             If an error response is returned by AmazonEC2 indicating
     *             either a problem with the data in the request, or a server
     *             side issue.
     */
    public <X extends AmazonWebServiceRequest> DryRunResult<X> dryRun(DryRunSupportedRequest<X> request) throws AmazonServiceException, AmazonClientException {
        Request<X> dryRunRequest = request.getDryRunRequest();
        ExecutionContext executionContext = createExecutionContext(dryRunRequest);
        try {
            invoke(dryRunRequest, null, executionContext);
            throw new AmazonClientException("Unrecognized service response for the dry-run request.");
        } catch (AmazonServiceException ase) {
            if (ase.getErrorCode().equals("DryRunOperation") && ase.getStatusCode() == 412) {
                return new DryRunResult<X>(true, request, ase.getMessage(), ase);
            } else if (ase.getErrorCode().equals("UnauthorizedOperation") && ase.getStatusCode() == 403) {
                return new DryRunResult<X>(false, request, ase.getMessage(), ase);
            }
            throw new AmazonClientException("Unrecognized service response for the dry-run request.", ase);
        }
    }

    /**
     * Returns additional metadata for a previously executed successful, request, typically used for
     * debugging issues where a service isn't acting as expected.  This data isn't considered part
     * of the result data returned by an operation, so it's available through this separate,
     * diagnostic interface.
     * <p>
     * Response metadata is only cached for a limited period of time, so if you need to access
     * this extra diagnostic information for an executed request, you should use this method
     * to retrieve it as soon as possible after executing the request.
     *
     * @param request
     *            The originally executed request
     *
     * @return The response metadata for the specified request, or null if none
     *         is available.
     */
    public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
        return client.getResponseMetadataForRequest(request);
    }

    private <X, Y extends AmazonWebServiceRequest> Response<X> invoke(Request<Y> request,
            Unmarshaller<X, StaxUnmarshallerContext> unmarshaller,
            ExecutionContext executionContext)
    {
        request.setEndpoint(endpoint);
        request.setTimeOffset(timeOffset);
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        for (Entry<String, String> entry : originalRequest.copyPrivateRequestParameters().entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        AWSCredentials credentials = awsCredentialsProvider.getCredentials();
        if (originalRequest.getRequestCredentials() != null) {
            credentials = originalRequest.getRequestCredentials();
        }

        executionContext.setSigner(getSigner());
        executionContext.setCredentials(credentials);
        
        StaxResponseHandler<X> responseHandler = new StaxResponseHandler<X>(unmarshaller);
        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);
        return client.execute(request, responseHandler, errorResponseHandler, executionContext);
    }
}
        
