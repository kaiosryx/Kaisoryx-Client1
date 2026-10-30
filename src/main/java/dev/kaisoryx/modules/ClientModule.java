package dev.kaisoryx.modules;

public final class ClientModule {
    private final String name;
    private final String description;
    private boolean enabled;
    public ClientModule(String name, String description, boolean enabled) {
        this.name = name; this.description = description; this.enabled = enabled;
    }
    public String name() { return name; }
    public String description() { return description; }
    public boolean enabled() { return enabled; }
    public void toggle() { enabled = !enabled; }
    public void setEnabled(boolean value) { enabled = value; }
}
