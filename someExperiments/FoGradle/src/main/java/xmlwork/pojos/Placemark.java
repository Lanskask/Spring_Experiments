package xmlwork.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Placemark {
    private Long id;

    private String ruName;
    private String enName;

    private String ruUrl;
    private String enUrl;

    private Double lon;
    private Double lat;
    private Double alt;

    private Long kmlId;

    // --------
    public String name;
    public String detailsUrl;
    public String detailsUrlEn;
    public String styleUrl;

    public Point point;
}
