import java.util.Set;
import java.util.TreeSet;

class Node implements Comparable<Node> {

  String name, birth = null, death = null;
  Node mother, father;
  Set<Node> children = new TreeSet<Node>();

  public Node(String name) {
    this.name = name;
  }

  public void printAncestors(int depth) {

    // Print itself
    if (depth != 0) {
      for (int i = 0; i < depth; i++)
        System.out.print("  ");
      if (birth == null)
        System.out.print(name);
      else if (death == null)
        System.out.print(name + " " + birth + " -");
      else
        System.out.print(name + " " + birth + " - " + death);
      System.out.println();
    }

    // Print parents
    if (father != null) {
      if (father.name.compareTo(mother.name) < 0) {
        father.printAncestors(depth + 1);
        mother.printAncestors(depth + 1);
      } else {
        mother.printAncestors(depth + 1);
        father.printAncestors(depth + 1);
      }
    }

  }

  public void printDescendants(int depth) {

    // Print itself
    if (depth != 0) {
      for (int i = 0; i < depth; i++)
        System.out.print("  ");
      if (birth == null)
        System.out.print(name);
      else if (death == null)
        System.out.print(name + " " + birth + " -");
      else
        System.out.print(name + " " + birth + " - " + death);
      System.out.println();
    }

    // Print children
    for (Node child: children)
      child.printDescendants(depth + 1);

  }

  // Children need to be sorted alphabetically
  @Override public int compareTo(Node other) {
    return name.compareTo(other.name);
  }

}