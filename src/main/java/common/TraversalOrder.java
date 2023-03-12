package common;

public enum TraversalOrder {
    IN_ORDER("inorder"),
    PRE_ORDER("preorder"),
    POST_ORDER("postorder");

    private String name;

    TraversalOrder(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}