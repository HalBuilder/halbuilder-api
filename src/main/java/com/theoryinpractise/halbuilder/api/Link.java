package com.theoryinpractise.halbuilder.api;

import java.util.regex.Pattern;

/**
 * A Link to an external resource.
 */
public class Link {
    /** Pattern that will hit an RFC 6570 URI template. */
    private static final Pattern URI_TEMPLATE_PATTERN = Pattern.compile("\\{.+\\}");

    private RepresentationFactory representationFactory;

    private String href;
    private String rel;
    private String name;
    private String title;
    private String hreflang;
    private String profile;
    private boolean hasTemplate = false;

    public Link(RepresentationFactory representationFactory, String rel, String href) {
        this.representationFactory = representationFactory;
        this.href = href;
        this.rel = rel;
        if(hasTemplate(href)) {
            this.hasTemplate = true;
        }
    }

    public Link(RepresentationFactory representationFactory, String rel, String href, String name, String title, String hreflang, String profile) {
        this(representationFactory, rel, href);
        this.name = name;
        this.title = title;
        this.hreflang = hreflang;
        this.profile = profile;
    }

    public String getHref() {
        return href;
    }

    public String getRel() {
        return rel;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getHreflang() {
        return hreflang;
    }

    public String getProfile() {
        return profile;
    }

    public boolean hasTemplate() {
        return hasTemplate;
    }

    /**
     * Determine whether the argument href contains at least one URI template,
     * as defined in RFC 6570.
     * @param href Href to check.
     * @return True if the href contains a template, false if not (or if the
     * argument is null).
     */
    private boolean hasTemplate(String href) {
        if(href == null) {
            return false;
        }
        return URI_TEMPLATE_PATTERN.matcher(href).find();
    }

    @Override
    public int hashCode() {
        int h = href.hashCode();
        h += rel.hashCode();
        if (name != null) {
            h += name.hashCode();
        }
        if (title != null) {
            h += title.hashCode();
        }
        if (profile != null) {
            h += profile.hashCode();
        }
        if (hreflang != null) {
            h += hreflang.hashCode();
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Link)) {
            return false;
        }
        Link that = (Link) obj;
        boolean e = this.href.equals(that.href);
        e &= this.rel.equals(that.rel);
        if (name != null) {
            e &= this.name.equals(that.name);
        }
        if (title != null) {
            e &= this.title.equals(that.title);
        }
        if (profile != null) {
            e &= this.profile.equals(that.profile);
        }
        if (hreflang != null) {
            e &= this.hreflang.equals(that.hreflang);
        }
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<link rel=\"").append(rel).append("\" href=\"").append(href).append("\"");
        if (name != null) {
            sb.append(" name=\"").append(name).append("\"");
        }
        if (title != null) {
            sb.append(" title=\"").append(title).append("\"");
        }
        if (profile != null) {
            sb.append(" profile=\"").append(profile).append("\"");
        }
        if (hreflang != null) {
            sb.append(" hreflang=\"").append(hreflang).append("\"");
        }
        sb.append("/>");

        return sb.toString();
    }
}
