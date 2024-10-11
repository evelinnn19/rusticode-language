package java;

public class Main {

    private static final String EXTENSION = "smp";

    public static void main(String[] args) throws IOException {
        String program = args.length > 1 ? args[1] : "test/test." + EXTENSION;

        System.out.println("Interpreting file " + program);

        SimpleLexer lexer = new SimpleLexer(new ANTLRFileStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleParser parser = new SimpleParser(tokens);

        SimpleParser.StartContext tree = parser.start();

        SimpleCustomVisitor visitor = new SimpleCustomVisitor();
        visitor.visit(tree);

        // Ejecutar el análisis semántico
        AnalizadorSemantico analizador = new AnalizadorSemantico();
        analizador.visit(tree);

        System.out.println("Interpretation finished");

    }

}