package processmanager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class ProcessManager implements IProcessManager {
	public ProcessManager(int max_memory_size) {
		used_memory_size=0;
		this.max_memory_size = max_memory_size;
		 processMaps=new HashMap<String,Process>();
		waitingProcessList=new LinkedList<Process>();
	}
	private int used_memory_size;
	private int max_memory_size;
	private HashMap<String,Process> processMaps;
	private LinkedList<Process> waitingProcessList;
	@Override
	public int getUsed_memory_size() {
		// TODO Auto-generated method stub
		return used_memory_size;
	}
	@Override
	public boolean add_process(User u, String processname, int required_memory) {
		// TODO Auto-generated method stub
		Process process=new Process(processname,required_memory,u);
		if(max_memory_size-used_memory_size>=required_memory)
		{
			processMaps.put(processname,process);
			used_memory_size+=required_memory;
			return true;
		}
		else
		{
			waitingProcessList.add(process);
			return false;
		}
	}
	@Override
	public boolean remove_process(String name) throws Exception {
		// TODO Auto-generated method stub
		if(!processMaps.containsKey(name)) {
			throw new Exception("Process not found");
		}
		else {
			used_memory_size-=processMaps.get(name).getRequired_memory();
			processMaps.remove(name);
			Iterator<Process> itr = waitingProcessList.iterator();
			while(itr.hasNext() && used_memory_size<=max_memory_size ) {
				Process my=itr.next();
				add_process( my.getUser(),  my.getName(), my.getRequired_memory());
			}
			return true;
		}
	}
	@Override
	public void print_processes() {
		for(Entry<String, Process> m : processMaps.entrySet()) {
			System.out.println(m.getValue() + ", " + m.getKey());
		}
		
	}
	@Override
	public void print_waiting_processes() {
		for(Process pr:waitingProcessList)
		{
			System.out.println(pr.getName()+" "+pr.getUser().getName());
		}
		
	}
	

}
