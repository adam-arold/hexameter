package org.codetome.hexameter.restexample.dto;

import lombok.Data;
import org.codetome.hexameter.core.api.DefaultSatelliteData;
import org.codetome.hexameter.core.api.Hexagon;

import java.util.Optional;

@Data
public class HexagonDto {
    /**
     * Represents the grid coordinate (x,z) of a Hexagon.
     * This is an AxialCoordinate.
     */
    private int[] gridCoordinate;
    /**
     * Represents the center point of a Hexagon (x, y).
     */
    private Double[] centerPoint;
    /**
     * Represents the (x,y) ponts of the edges of a Hexagon.
     */
    private Double[][] points;

    /**
     * Represents the satellite data stored in the source Hexagon (if any).
     */
    private DefaultSatelliteData satelliteData;

    public static HexagonDto fromHexagon(final Hexagon hexagon) {
        HexagonDto result = new HexagonDto();
        result.setCenterPoint(new Double[]{hexagon.getCenterX(), hexagon.getCenterY()});
        result.setGridCoordinate(new int[]{hexagon.getGridX(), hexagon.getGridZ()});
        Double[][] points = new Double[6][2];
        for (int i = 0; i < 6; i++) {
            points[i][0] = hexagon.getPoints().get(i).getCoordinateX();
            points[i][1] = hexagon.getPoints().get(i).getCoordinateY();
        }
        result.setPoints(points);
        final Optional<DefaultSatelliteData> satelliteData = hexagon.getSatelliteData();
        if (satelliteData.isPresent()) {
            result.setSatelliteData(satelliteData.get());
        }
        return result;
    }
}
