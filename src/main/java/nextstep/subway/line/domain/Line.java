package nextstep.subway.line.domain;

import static java.util.Collections.singletonList;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import nextstep.subway.BaseEntity;
import nextstep.subway.station.domain.Station;

@Entity
public class Line extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Name name;
    private String color;
    @Embedded
    private Sections sections;

    protected Line() {
    }

    public Line(String name, String color) {
        this.name = Name.from(name);
        this.color = color;
    }

    public Line(String name, String color, Station upStation, Station downStation, int distance) {
        Section section = Section.of(this, upStation, downStation, distance);
        this.name = Name.from(name);
        this.color = color;
        this.sections = Sections.from(singletonList(section));
    }

    public void update(Line line) {
        this.name = line.name;
        this.color = line.color;
    }

    public void addSection(Section section) {
        sections.addSection(section);
    }

    public List<Station> findStations() {
        return sections.findStations();
    }

    public List<Station> findInOrderStations() {
        return sections.findInOrderStations();
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<Section> getSections() {
        return sections.getSections(); // TODO 리팩토링 필요
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
