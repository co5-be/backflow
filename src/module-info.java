module CO5Client {
    requires java.base;
    requires com.google.gson;
    requires transitive java.logging;
    exports co5.client;
}
