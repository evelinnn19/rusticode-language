package ast;

import java.util.HashMap;

import java.util.ArrayList;

public class While implements ASTNode {
    private ASTNode condition;
    private ArrayList<ASTNode> whilebody;

    public While(ASTNode condition, ArrayList<ASTNode> whilebody) {
        super();
        this.condition = condition;
        this.whilebody = whilebody;
    }

    public ASTNode getCondition() {
        return condition;
    }

    public ArrayList<ASTNode> getWhilebody() {
        return whilebody;
    }

    @Override
    public Object execute(HashMap<String, Object> Table) {
        while (condition.execute(Table) == Boolean.TRUE) {
            for (ASTNode n : whilebody) {
                n.execute(Table);
            }
        }
        return null;
    }
}
