package streamsapi;

abstract class Widget{
    String data = "data";
    public void doWidgetStuff() {     }
}
public class Q3_abstractClass extends Widget{
    Widget w = new Widget() {
        @Override
        public void doWidgetStuff() {
            super.doWidgetStuff();
        }
    };
    String data = "big data";
    public void doWidgetStuff() {
        System.out.println(data);     }
}


