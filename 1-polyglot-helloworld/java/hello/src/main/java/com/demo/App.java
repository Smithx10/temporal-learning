package com.demo;

/**
 * Hello world!
 *
 */

import com.demo.workflow.Workflow;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;
import io.temporal.client.WorkflowOptions;

public class App 
{

    public static final String TASK_QUEUE = "hello-world";
    public static final String WORKFLOW_ID = "hello_world_workflowID";

    public static void main(String[] args) {
      WorkflowServiceStubs service =
        WorkflowServiceStubs.newInstance(
            WorkflowServiceStubsOptions.newBuilder()
                .setTarget("fe.svc.bdf-cadence.us-east.bdf-cloud.iqvia.net:7233")
                .build());

      WorkflowClient client = WorkflowClient.newInstance(service);
      WorkflowOptions goWorkflowOptions =
                WorkflowOptions.newBuilder().setTaskQueue(TASK_QUEUE).setWorkflowId(WORKFLOW_ID).build();

      Workflow workflow = client.newWorkflowStub(Workflow.class, goWorkflowOptions);

      System.out.println( workflow.exec("rawr") );
      try {
          Thread.sleep(10 * 1000);
      } catch (Exception e) {
          e.printStackTrace();
      }
      System.exit(0);
    }
}
