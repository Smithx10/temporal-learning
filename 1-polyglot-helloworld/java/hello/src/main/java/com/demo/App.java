package com.demo;

/**
 * Hello world!
 *
 */

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class App 
{

    public static final String TASK_QUEUE = "hello-world";
    public static final String WORKFLOW_ID = "hello_world_workflowID";

    public static void main(String[] args) {

      WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();
      WorkflowClient client = WorkflowClient.newInstance(service);
      WorkflowOptions goWorkflowOptions =
                WorkflowOptions.newBuilder().setTaskQueue(TASK_QUEUE).setWorkflowId(WORKFLOW_ID).build();

      //SimpleWorkflow workflow = client.newWorkflowStub(SimpleWorkflow.class, goWorkflowOptions);
    }
}
