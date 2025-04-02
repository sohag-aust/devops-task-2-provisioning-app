### Provisioning App for DevOps Task-2
    How Overlay Network and mode: host Work Separately?
    Docker overlay networking is used for inter-container communication between nodes in a Swarm cluster.

    It allows services on different nodes to communicate as if they were on the same network.

    Traffic flows through Swarm’s built-in VXLAN overlay (this is why docker network inspect shows virtual IPs).

    On the other hand, using mode: host for published ports only affects external connections:

    It removes Docker's routing mesh and exposes the service only on the node it runs on.

    Internal service-to-service communication still happens over the overlay network.

    🔹 Do mode: host and overlay networks conflict?
    No, they don't conflict! They serve different purposes:
    ✅ Overlay Network → Internal communication (service-to-service across nodes).
    ✅ mode: host → External communication (bypasses Swarm routing and binds to a specific node’s IP).

    🔹 How do they work together?
    Between containers inside Swarm: They still communicate over the overlay network.

    External access: When you access a node's IP (e.g., 192.168.10.12:8085), it routes only to the container on that node (not through routing mesh).

    🔹 Why This Works?
    Containers still communicate via the overlay network for inter-container traffic.

    External requests reach only the container on that node (no Swarm routing mesh).

    Each worker node handles its own traffic, meaning when you hit 192.168.10.12:8085, it only serves traffic from that node's container.

    🔹 Summary
    🔹 Overlay network → Handles container-to-container communication inside Swarm.
    🔹 Host mode for ports → Ensures external traffic reaches the correct node without routing mesh.
    🔹 No conflict because networking layers are separate (Swarm VXLAN for overlay vs. direct host networking for external access).

    Let me know if you need further clarification! 


