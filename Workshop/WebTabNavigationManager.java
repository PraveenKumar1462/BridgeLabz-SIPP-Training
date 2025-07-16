package Workshop;

import java.util.Stack;


interface NavigationManager {
    void openTab(String url);
    String back();
    String forward();
    String getCurrentTab();
}

public class WebTabNavigationManager implements NavigationManager {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentTab = null;

    @Override
    public void openTab(String url) {
        if (currentTab != null) {
            backStack.push(currentTab);
        }
        currentTab = url;
        forwardStack.clear();
    }

    @Override
    public String back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentTab);
            currentTab = backStack.pop();
        }
        return currentTab;
    }

    @Override
    public String forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentTab);
            currentTab = forwardStack.pop();
        }
        return currentTab;
    }

    @Override
    public String getCurrentTab() {
        return currentTab;
    }

    public static void main(String[] args) {
        NavigationManager nav = new WebTabNavigationManager();
        nav.openTab("google.com");
        nav.openTab("github.com");
        nav.openTab("stackoverflow.com");
        System.out.println("Current: " + nav.getCurrentTab());
        nav.back();
        System.out.println("Back: " + nav.getCurrentTab());
        nav.back();
        System.out.println("Back: " + nav.getCurrentTab());
        nav.forward();
        System.out.println("Forward: " + nav.getCurrentTab());
    }
}