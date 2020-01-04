package interview.logical;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.TextEdit;

public class Indentation {

	public static void main(String args[]) {
        System.out.println("Hello World");
        String input = "public class PrettyPrint { public static void main(String args[]) { System.out.println(\"Hello World\"); String input = \"This is a sample code\"; System.out.println(Indent(input)); } public static String Indent(String input) { return \"Indented: \" + input; } }";
        System.out.println(Indent(input));

    }

    public static String Indent(String input) {
        //Code goes here
        CodeFormatter codeFormatter = ToolFactory.createCodeFormatter(null);
		TextEdit textEdit = codeFormatter.format(CodeFormatter.K_COMPILATION_UNIT, input, 0, input.length(), 0, null);
		IDocument doc = new Document(input);
		try {
			textEdit.apply(doc);
			//return doc.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(input);
		String f[] = input.split("\\{ ");
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < f.length; i++) {
			String space = "";
			int sCount = i;
			while (sCount != 0 && sCount <= i*4) {
				if (sCount == i) {
					space += "\n";
				}
				space += " ";
				sCount++;
			}
			if (f[i].contains("}")) {
				buffer.append(space + f[i] + "}");
			}
			buffer.append(space + f[i] + "{");
			System.out.print(f[i]);
		}
		return null;
    }
}
