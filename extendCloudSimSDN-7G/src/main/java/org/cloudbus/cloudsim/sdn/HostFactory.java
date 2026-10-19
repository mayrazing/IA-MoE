package org.cloudbus.cloudsim.sdn;

import org.cloudbus.cloudsim.sdn.physicalcomponents.SDNHost;

public interface HostFactory {
	public abstract SDNHost createHost(int ram, long bw, long storage, long pes, double mips, String name);

	public abstract SDNHost createHost(int ram, long ramBw, long bw, long storage, long pes, double mips, String name);
}
