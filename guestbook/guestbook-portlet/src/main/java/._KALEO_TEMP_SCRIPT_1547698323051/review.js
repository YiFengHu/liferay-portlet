int handlerUserId = 22516; 
long dueDate = System.currentTimeMillis() + (1000*60*60*24*2);

System.out.println("--------------------Workflow assign script start--------------------");
System.out.println("company: "+Company+", id = "+companyId);
System.out.println("entryClassName: "+entryClassName);
System.out.println("entryClassPK: "+entryClassPK);
System.out.println("Group: "+Group+", group id = "+groupId);
System.out.println("serviceContext: "+serviceContext);
System.out.println("User: "+user+", userID = "+userId);

System.out.println("workflowContext= "+workflowContext);

System.out.println("--------------------Workflow assign script end--------------------");

com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil.assignWorkflowTaskToUser(
			companyId, userId, workflowTaskId,
			handlerUserId, "Auto Assign to You", dueDate, workflowContext);