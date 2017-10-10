import java.io.*;
import java.util.*;

public class GenealogicalResearch
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Map<String, Node> nodes = new HashMap<String, Node>();
	static int index;

	public static void main(String[] args) throws IOException {
		boolean needNewLine = false;

		loop : while(true) {
			String[] line = br.readLine().split(" ");

			switch(line[0]) {
				case "QUIT":
					break loop;
				case "BIRTH":
					index = 1;
					String child = buildString(line);
					String date = buildString(line);
					String mother = buildString(line);
					String father = buildString(line);

					Node childNode = getNode(child);
					Node motherNode = getNode(mother);
					Node fatherNode = getNode(father);

					childNode.birth = date;
					childNode.mother = motherNode;
					childNode.father = fatherNode;

					motherNode.children.add(childNode);
					fatherNode.children.add(childNode);
					break;

				case "DEATH":
					index = 1;
					String person = buildString(line);
					date = buildString(line);
					Node node = getNode(person);
					node.death = date;
					break;

				case "ANCESTORS":
					if (needNewLine) {
						System.out.println();
						needNewLine = false;
					}
					index = 1;
					person = buildString(line);
					node = getNode(person);

					System.out.println("ANCESTORS of " + person);
					node.printAncestors(0);

					needNewLine = true;

					break;

				case "DESCENDANTS":
					if (needNewLine) {
						System.out.println();
						needNewLine = false;
					}
					index = 1;
					person = buildString(line);
					node = getNode(person);

					System.out.println("DESCENDANTS of " + person);
					node.printDescendants(0);
					needNewLine = true;

					break;
			}
		}
	}

	static String buildString(String[] split) {
		String str = "";
		while (index < split.length && !split[index].equals(":"))
			str += " " + split[index++];
		index++;
		return str.trim();
	}

	static Node getNode(String name) {
		if (nodes.containsKey(name))
			return nodes.get(name);
		Node node = new Node(name);
		nodes.put(name, node);
		return node;
	}

}