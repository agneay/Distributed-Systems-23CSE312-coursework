<div align="center">

# Distributed Systems

### 23CSE312 · B.Tech Computer Science and Engineering

<p>
  <img src="https://img.shields.io/badge/Language-Python-blue?logo=python" alt="Python">
  <img src="https://img.shields.io/badge/Language-Java-orange?logo=openjdk" alt="Java">
  <img src="https://img.shields.io/badge/Course-Distributed%20Systems-green" alt="Distributed Systems">
  <img src="https://img.shields.io/badge/University-Amrita%20Vishwa%20Vidyapeetham-red" alt="Amrita Vishwa Vidyapeetham">
  <img src="https://img.shields.io/badge/Status-In%20Progress-yellow" alt="In Progress">
</p>

**Learn · Implement · Experiment · Build**

</div>

---

## Table of Contents

- [About This Repository](#about-this-repository)
- [Course Information](#course-information)
- [Course Description](#course-description)
- [Course Objectives](#course-objectives)
- [Course Syllabus](#course-syllabus)
  - [Unit I — Fundamentals, Communication, Cloud and Edge Computing](#unit-i--fundamentals-of-distributed-systems-communication-cloud-and-edge-computing)
  - [Unit II — Coordination, Synchronization and Consensus](#unit-ii--distributed-coordination-synchronization-and-consensus)
  - [Unit III — Consistency, Replication, Fault Tolerance and Recovery](#unit-iii--consistency-replication-fault-tolerance-and-recovery)
- [Course Outcomes](#course-outcomes)
- [Repository Structure](#repository-structure)
- [Laboratory Programs](#laboratory-programs)
- [Technologies and Tools](#technologies-and-tools)
- [Evaluation Pattern](#evaluation-pattern)
- [Recommended Textbooks](#recommended-textbooks)
- [Learning Resources](#learning-resources)
- [Coursework Progress Tracker](#coursework-progress-tracker)
- [Getting Started](#getting-started)
- [Contribution and Usage](#contribution-and-usage)
- [Disclaimer](#disclaimer)
- [License](#license)

---

## About This Repository

Welcome to my **Distributed Systems (23CSE312)** coursework repository!

This repository brings together the learning materials and practical work completed as part of the B.Tech Computer Science and Engineering curriculum at **Amrita Vishwa Vidyapeetham**.

It is intended to serve as an organized academic workspace for:

- Lecture notes and concept summaries
- Laboratory programs and practical implementations
- Assignments and tutorials
- Distributed systems case studies
- Projects and experiments
- Useful documentation, books and research resources

The goal is to connect the theoretical foundations of distributed computing with practical implementations and real-world systems.

## Course Information

| Particular | Details |
|---|---|
| **University** | Amrita Vishwa Vidyapeetham |
| **Program** | B.Tech Computer Science and Engineering |
| **Course** | Distributed Systems |
| **Course Code** | 23CSE312 |
| **Semester** | 6 |
| **Credits** | 4 |
| **Category** | Core |
| **Official Course Page** | [B.Tech Distributed Systems — Amrita](https://www.amrita.edu/course/btech-distributed-systems/) |

## Course Description

Distributed Systems studies systems in which multiple independent computers communicate and coordinate to perform common tasks.

The course introduces fundamental distributed computing concepts, communication models, synchronization mechanisms, distributed algorithms, consistency models, replication, fault tolerance and recovery techniques.

It also explores cloud computing, edge computing, distributed file systems and modern distributed platforms. Through theory and practical implementation, the course develops an understanding of how scalable, reliable and fault-tolerant distributed applications are designed.

## Course Objectives

- Understand the fundamental principles and architectures of distributed systems.
- Study different models of distributed computation and communication.
- Understand socket programming and Remote Procedure Calls (RPC).
- Explore synchronization, logical clocks and distributed coordination.
- Learn distributed mutual exclusion and leader election algorithms.
- Understand consensus algorithms such as Paxos and Raft.
- Study consistency models, data replication and replica management.
- Understand fault tolerance, failure detection and recovery mechanisms.
- Explore cloud computing, edge computing and distributed storage.
- Develop practical distributed applications using modern programming languages and platforms.

---

## Course Syllabus

### Unit I — Fundamentals of Distributed Systems, Communication, Cloud and Edge Computing

**1. Models of Computation**
- Shared memory systems
- Message passing systems
- Synchronous distributed systems
- Asynchronous distributed systems

**2. Communication in Distributed Systems**
- Remote Procedure Calls (RPC)
- Message-oriented communication
- Communication protocols
- Implementation of a simple distributed system

**3. Cloud Computing**
- Introduction to cloud computing
- Cloud computing models
- Cloud service models
- Cloud deployment models
- Cloud architectures

**4. Edge Computing**
- Edge devices
- Fog computing
- Edge-cloud computing
- Edge computing architectures

**5. Current Research Trends**
- Edge intelligence
- Edge security

**Practical areas**
- TCP and UDP socket programming
- Client-server architecture
- Single-client and multi-client server implementation
- Remote Procedure Calls
- Cloud and edge computing fundamentals

### Unit II — Distributed Coordination, Synchronization and Consensus

**1. Global State**
- Global state in distributed systems
- Snapshot algorithms
- Distributed snapshots

**2. Logical Time and Event Ordering**
- Logical clocks
- Lamport timestamps
- Vector clocks
- Event ordering
- Clock synchronization

**3. Distributed Coordination**
- Distributed mutual exclusion
- Group-based mutual exclusion
- Leader election algorithms

**4. Concurrency Control**
- Concurrency management
- Deadlock detection
- Termination detection

**5. Consensus Algorithms**
- Introduction to consensus
- Paxos algorithm
- Raft algorithm
- Consensus algorithm variants

**6. Edge Computing**
- Edge intelligence algorithms
- Distributed inference
- Edge caching

**7. Current Research Trends**
- Distributed machine learning
- Blockchain
- Quantum computing

**Practical areas**
- Lamport logical clock implementation
- Vector clock simulation
- Distributed mutual exclusion
- Leader election algorithms
- Distributed deadlock detection
- Consensus algorithm simulation

### Unit III — Consistency, Replication, Fault Tolerance and Recovery

**1. Consistency Models**
- Data-centric consistency
- Client-centric consistency
- Consistency protocols

**2. Replica Management**
- Data replication
- Replica management techniques
- Replica synchronization

**3. Fault Tolerance and Recovery**
- Fundamental concepts of fault tolerance
- Fault models
- Agreement problems and applications
- Commit protocols
- Voting protocols
- Checkpointing
- Recovery mechanisms

**4. Distributed File Systems**
- Distributed file system architecture
- Scalable performance
- Load balancing
- Availability

**5. Edge Computing**
- Edge data management
- Edge security
- Edge fault tolerance

**6. Current Research Trends**
- Edge AI for fault tolerance
- Hybrid cloud and edge architectures

**Distributed systems case studies**
- HDFS / Hadoop
- Apache Helix
- GoBeam
- Folding@home
- Apache Spark
- Apache Storm
- Apache Flink
- Amazon DynamoDB
- Gizzard
- Google File System
- Bigtable / HBase
- Google Spanner
- Amazon Aurora
- Blockchain
- etcd
- Apache ZooKeeper

---

## Course Outcomes

After completing this course, students should be able to:

| Outcome | Description |
|---|---|
| **CO1** | Understand the design principles and architectures of distributed systems. |
| **CO2** | Apply distributed algorithms related to clock synchronization, concurrency control, deadlock detection, load balancing and voting. |
| **CO3** | Analyze fault tolerance, recovery mechanisms and related algorithms. |
| **CO4** | Analyze the design and functioning of existing edge, cloud and distributed file systems. |
| **CO5** | Implement distributed algorithms using current distributed platforms. |

## Repository Structure

The repository is organized into folders for theory, laboratory work, assignments, tutorials, case studies, projects and reference material.

```text
distributed-systems/
│
├── README.md
│
├── notes/
│   ├── unit-1/
│   │   ├── distributed-system-basics.md
│   │   ├── computation-models.md
│   │   ├── communication-models.md
│   │   ├── rpc.md
│   │   ├── cloud-computing.md
│   │   └── edge-computing.md
│   │
│   ├── unit-2/
│   │   ├── global-state.md
│   │   ├── logical-clocks.md
│   │   ├── vector-clocks.md
│   │   ├── clock-synchronization.md
│   │   ├── mutual-exclusion.md
│   │   ├── leader-election.md
│   │   └── consensus-algorithms.md
│   │
│   └── unit-3/
│       ├── consistency-models.md
│       ├── replication.md
│       ├── fault-tolerance.md
│       ├── recovery.md
│       └── distributed-file-systems.md
│
├── lab/
│   ├── python/
│   │   ├── socket-programming/
│   │   ├── client-server/
│   │   ├── multi-client-server/
│   │   └── distributed-algorithms/
│   │
│   ├── java/
│   │   ├── socket-programming/
│   │   ├── client-server/
│   │   ├── multi-client-server/
│   │   └── distributed-algorithms/
│   │
│   └── README.md
│
├── assignments/
│   ├── assignment-1/
│   ├── assignment-2/
│   └── assignment-3/
│
├── tutorials/
│   ├── tcp-udp/
│   ├── rpc/
│   ├── logical-clocks/
│   └── consensus/
│
├── case-studies/
│   ├── hadoop/
│   ├── apache-spark/
│   ├── apache-flink/
│   ├── zookeeper/
│   ├── etcd/
│   └── blockchain/
│
├── projects/
│   └── README.md
│
├── resources/
│   ├── reference-books.md
│   ├── useful-links.md
│   └── research-papers.md
│
└── LICENSE
```

> This is a suggested repository layout. Update the tree as folders and files are added to the actual repository.

## Laboratory Programs

The laboratory section contains practical implementations using **Python** and **Java**.

### Python

| Experiment | Description |
|---|---|
| Socket Programming | Basic TCP socket communication |
| Client-Server | Communication between a client and server |
| Multi-Client Server | Handling multiple clients using threading |
| UDP Communication | Connectionless communication |
| Distributed Algorithms | Implementation of distributed algorithms |

### Java

| Experiment | Description |
|---|---|
| Socket Programming | TCP socket implementation |
| Client-Server | Java client-server communication |
| Multi-Client Server | Handling multiple clients using threads |
| Distributed Algorithms | Implementation of distributed algorithms |

### Multi-Client Server Implementation

One practical exercise demonstrates how a single server can handle multiple clients simultaneously. Each connected client is handled using a separate thread, allowing concurrent communication.

**Python technologies**
- `socket`
- `threading`

**Java technologies**
- `ServerSocket`
- `Socket`
- `Thread`
- `Runnable`

## Technologies and Tools

| Category | Technologies |
|---|---|
| Programming Languages | Python, Java, C/C++ |
| Networking | TCP, UDP, Socket Programming |
| Communication | RPC, Message Passing |
| Concurrency | Multithreading |
| Distributed Processing | Apache Spark, Apache Flink |
| Distributed Storage | HDFS, HBase |
| Coordination | Apache ZooKeeper, etcd |
| Cloud Computing | AWS, Google Cloud |
| Containerization | Docker |
| Version Control | Git, GitHub |

## Evaluation Pattern

The course evaluation follows the **70:30 assessment structure** described on the course page.

| Assessment Component | Weightage |
|---|---:|
| Midterm | 20 |
| Continuous Assessment (Theory) | 10 |
| Continuous Assessment (Lab) | 40 |
| End Semester | 30 |
| **Total** | **100** |

Continuous assessment includes theory and laboratory components such as quizzes, tutorials, practical assessments, projects, case studies and reports.

Refer to the [official course page](https://www.amrita.edu/course/btech-distributed-systems/) for the latest evaluation details.

## Recommended Textbooks

1. George Coulouris, Jean Dollimore and Tim Kindberg — *Distributed Systems: Concepts and Design*, 5th Edition, Pearson, 2011.
2. Ajay D. Kshemkalyani and Mukesh Singhal — *Distributed Computing: Principles, Algorithms, and Systems*, Cambridge University Press, 2011.
3. Kai Hwang, Jack Dongarra and Geoffrey Fox — *Distributed and Cloud Computing: From Parallel Processing to the Internet of Things*, Morgan Kaufmann, 2012.
4. Rajkumar Buyya, James Broberg and Andrzej M. Goscinski — *Cloud Computing: Principles and Paradigms*, Wiley, 2011.
5. Rajkumar Buyya and Satish Narayana Srirama — *Fog and Edge Computing: Principles and Paradigms*, Wiley, 2019.

## Learning Resources

### Official Course
- [Amrita — Distributed Systems](https://www.amrita.edu/course/btech-distributed-systems/)

### Programming Documentation
- [Python Documentation](https://docs.python.org/3/)
- [Java Documentation](https://docs.oracle.com/en/java/)

### Networking
- [Python Socket Programming](https://docs.python.org/3/library/socket.html)
- [Python Threading](https://docs.python.org/3/library/threading.html)
- [Java Socket API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/net/Socket.html)
- [Java ServerSocket API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/net/ServerSocket.html)

### Distributed Technologies
- [Apache Hadoop](https://hadoop.apache.org/)
- [Apache Spark](https://spark.apache.org/)
- [Apache Flink](https://flink.apache.org/)
- [Apache ZooKeeper](https://zookeeper.apache.org/)
- [etcd Documentation](https://etcd.io/docs/)

---

## Coursework Progress Tracker

Use the checklists below to track progress during the semester. Check an item when the corresponding topic or task is complete.

### Theory

**Unit I**
- [ ] Distributed System Fundamentals
- [ ] Models of Computation
- [ ] Communication Models
- [ ] Remote Procedure Calls
- [ ] Cloud Computing
- [ ] Edge Computing

**Unit II**
- [ ] Global State
- [ ] Logical Clocks
- [ ] Vector Clocks
- [ ] Clock Synchronization
- [ ] Distributed Mutual Exclusion
- [ ] Leader Election
- [ ] Deadlock Detection
- [ ] Consensus Algorithms

**Unit III**
- [ ] Consistency Models
- [ ] Replica Management
- [ ] Fault Tolerance
- [ ] Recovery Mechanisms
- [ ] Distributed File Systems
- [ ] Edge Data Management

### Practical
- [ ] Python Socket Programming
- [ ] Java Socket Programming
- [ ] TCP Client-Server Implementation
- [ ] Multi-Client Server Implementation
- [ ] UDP Communication
- [ ] Distributed Algorithm Implementations
- [ ] Case Studies
- [ ] Course Project

### Academic Work
- [ ] Assignments
- [ ] Tutorials
- [ ] Lab Records
- [ ] Practical Assessments
- [ ] Midterm Preparation
- [ ] End Semester Preparation

## Getting Started

### 1. Clone the repository

Replace `YOUR-USERNAME` with your GitHub username or use the URL of your repository.

```bash
git clone https://github.com/YOUR-USERNAME/distributed-systems.git
cd distributed-systems
```

### 2. Explore the folders

Navigate to the relevant unit, laboratory, assignment or case-study folder.

### 3. Run the programs

Use the appropriate Python or Java environment for the implementation. Check individual folders for any program-specific instructions or dependencies.

### 4. Commit your updates

```bash
git add .
git commit -m "Update distributed systems coursework"
git push origin main
```

## Contribution and Usage

This repository is primarily maintained as a personal academic coursework archive.

You are welcome to explore the source code and learning materials for educational purposes. Suggestions, corrections and improvements are welcome through GitHub Issues and Pull Requests.

Please follow your institution's academic integrity guidelines when using coursework or code from this repository.

## Disclaimer

This is an independently maintained student repository and is **not an official repository of Amrita Vishwa Vidyapeetham**.

Course information, syllabus and evaluation details are based on the material referenced in this repository and may be subject to change. Refer to the official course page and university announcements for authoritative updates.

All source code and notes are intended for educational and academic reference. Third-party materials remain the property of their respective authors and owners.

## License

Original code and documentation in this repository are intended to be shared under the **MIT License**, where applicable.

Third-party resources and copyrighted educational materials are excluded from this license. Include a `LICENSE` file in the repository if you intend to distribute original work under the MIT License.

---

<div align="center">

**Distributed Systems · 23CSE312**

B.Tech Computer Science and Engineering  
Amrita Vishwa Vidyapeetham

*Learn. Implement. Experiment. Build.*

⭐ If you find this repository useful, consider giving it a star!

</div>
