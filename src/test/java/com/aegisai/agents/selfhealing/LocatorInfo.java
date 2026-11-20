package com.aegisai.agents.selfhealing;
// Locator ke saare backup options store karega.
public class LocatorInfo {
	private String id;

    private String name;

    private String css;

    private String xpath;

    public LocatorInfo(
            String id,
            String name,
            String css,
            String xpath) {

        this.id = id;
        this.name = name;
        this.css = css;
        this.xpath = xpath;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCss() {
        return css;
    }

    public String getXpath() {
        return xpath;
    }
}
