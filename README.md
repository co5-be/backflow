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

# Low Code

Only a jar with dependencies (also known as uber jar) is required. Within this jar only a hook class needs to be exposed so the domain logic can be plugged in the different workers. No attributes are used to avoid scanning of classes. The processing is defined by a list of steps using functional programming. From initial service request to custom live endpoint, it takes less than 10 minutes.

# Authorization

One last functional programming requirement is the authorization callback. Before any request is processed, a callback to the authorization function is made. If the request is valid then processing can continue.

# Autoscaling

Currently the user can specify the number of cpus required (as a multiple of 1024, say two cpus would be 2048) and the max capacity utilization needed to trigger scaling up (say 90 for 90% utilization trigger) The scaling down is left to provider defaults. The initial instance count is 1 and the limit is 20 instances.

# Metering

Central to metering is the concept of serviced request. A request is serviced if: it was complete or if the max number of retries has been reached. Logic is in place to allow users: to set the return status and payload of responses as needed. The current number of retries is 2. After any of these conditions is met, the request will be counted. Once the initial limit is reached then the scraping of the cloud resources will be automatically started. Current limit is **100**.

