public class intersectList {

    public static LinkNode findIntersectNode(LinkNode node1, LinkNode node2) {
        LinkNode cur = null;
        while(node1 != null && node2 != null) {
            cur = node1;
            if(node1 == node2) {
                return cur;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
