# IA-MoE

Java simulation source code for IA-MoE research, based on CloudSim and CloudSimSDN. The current repository focuses on cloud and edge simulation infrastructure, including host and virtual machine resource management, SDN networking, VM placement and migration, service function chaining, resource monitoring, and energy accounting.

## Directory Structure

```text
IA-MoE/
├── extendCloudSimSDN-7G/
│   └── src/main/java/org/cloudbus/cloudsim/
│       ├── core/                # Simulation events and core interfaces
│       ├── provisioners/        # Host resource provisioning
│       ├── selectionPolicies/   # Resource selection policies
│       ├── network/             # Network and data center models
│       ├── power/               # Power models and energy-related policies
│       ├── container/           # Container simulation
│       ├── EX/                  # VM lifecycle, billing, and other extensions
│       ├── geolocation/         # Geolocation and network latency models
│       ├── web/                 # Web workload simulation
│       └── sdn/                 # CloudSimSDN extensions and examples
├── README.md
└── LICENSE
```

The root of the `org.cloudbus.cloudsim` package also contains `Cloudlet`, `Host`, `Vm`, `Datacenter`, and related scheduling and allocation classes.

## SDN Modules

The following directories are under `extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/`.

| Directory | Purpose |
|---|---|
| `physicalcomponents/` | Physical network components, including hosts, switches, and links |
| `virtualcomponents/` | Virtual components, including SDN virtual machines |
| `nos/` | Network operating systems and network resource management |
| `parsers/` | Physical topology, virtual topology, and workload parsing |
| `policies/` | VM placement, host selection, and link selection policies |
| `provisioners/` | Resource provisioning extensions for SDN scenarios |
| `sfc/` | Service function chaining and forwarding |
| `workload/` | Requests, processing activities, transmissions, and result recording |
| `monitor/` | Resource utilization and energy monitoring |
| `example/` | Simulation examples and topology generators |

## Example Entry Points

Example classes are in the `org.cloudbus.cloudsim.sdn.example` package.

| Entry point | Purpose |
|---|---|
| [SimpleExample](extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/example/SimpleExample.java) | Loads a single-data-center topology, VM deployment configuration, and workloads |
| [SimpleExampleInterCloud](extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/example/SimpleExampleInterCloud.java) | Simulates multiple data centers and inter-cloud communication |
| [SimpleExamplePolicies](extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/example/SimpleExamplePolicies.java) | Demonstrates VM allocation policies |
| [SimpleExampleSelectLinkBandwidth](extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/example/SimpleExampleSelectLinkBandwidth.java) | Demonstrates link bandwidth selection policies |

The `main` methods of `SimpleExample` and `SimpleExampleInterCloud` read arguments in this order:

```text
policy  physical.json  virtual.json  [working_directory]  [workload1.csv]  [workload2.csv] ...
```

Both default to the `LFF` policy. After the topology arguments, an argument that does not end in `.csv` is treated as the working directory; subsequent arguments are workload files. Consult each entry point for its policy branches and default file paths.

Physical topologies describe data centers, nodes, and links. Virtual topologies describe VM resources, placement, and virtual links. [WorkloadParser](extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/parsers/WorkloadParser.java) defines the workload field order, including arrival time, submission VM, packet size, processing length, and subsequent transmission activities. VM and link names in workload files must match the deployment configuration.

## Build and Run Preparation

The Java source root is `extendCloudSimSDN-7G/src/main/java`. The repository currently provides no Maven, Gradle, or Ant build configuration and does not declare JDK or dependency versions. Configure the source root and dependencies in your Java project before compiling.

Source imports reference the following third-party libraries:

- Guava.
- JSON.simple.
- Apache Commons Math, Lang, IO, and Net.
- OpenCSV.
- Jackson Annotations.
- MaxMind GeoIP2.
- Uncommons Maths.

This list identifies source dependencies; it is not a validated dependency version set. Before running an example, prepare topology and workload files compatible with the selected entry point and parsers. The default example data paths referenced by the entry points are not included in the current repository.

Simulation settings are defined in [Configuration.java](extendCloudSimSDN-7G/src/main/java/org/cloudbus/cloudsim/sdn/Configuration.java). `SimpleExample` and `SimpleExampleInterCloud` write logs according to the working directory and experiment directory settings. Other outputs depend on the selected entry point and enabled monitoring logic.

## License

The repository includes the GNU GPL v2 license text. See [LICENSE](LICENSE). Third-party dependencies retain their respective licenses.
