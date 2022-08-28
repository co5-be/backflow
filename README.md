# Backflow: A low code, cloud native backend service on demand 

To a large extent, being able to execute domain knowlegde/expertise quickly and efficiently on the cloud is the main purpose of digitization efforts. As these efforts advance, things get complicated when unavoidably content needs to be processed. 

Depending on the type of content/document processed computing needs can be all over the place. Then there is the selection of a processing library. One not suited to the task can sour any good progress achieved. Selecting the appropriate library brings other challenges: which content size triggers expensive scaling? Do these computing resources need to be available constantly? How to handle failures/reprocessing? Are the resources safe and secured?

When millions of documents are to be processed on a deadline, one needs to have those questions answered. Planning at times gets punched in the nose by reality.

Enter Backflow. With its low code requirements, domain knowledge can be encapsulated and deployed to a private, custom cloud computing sandbox (see table) only when the need arises. Sandbox deployment takes less than **5 minutes**. Jobs are **metered**, i.e: an initial size is requested and if this limit is reached resources will be removed automatically. The benefits of this approach, in addtion to effeciency, is security: if the resources are not deployed, then they can not be hacked. Furthermore, auth tasks are the in users' control. Every request is backed up and a fail-safe system ensures that in the event system crashes every request is completed.

VPC Resources |Access
-----|------
VPN 1|RESTRICTED(2) 
ALB|RESTRICTED
VPN 2|PRIVATE
ECS Cluster(1) |PRIVATE
S3 BUCKET|RESTRICTED

(1) Autoscaling enabled according to job requirements
(2) Every restricted resource is tied to an specific, user-provided IP address



