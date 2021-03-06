/* uDig - User Friendly Desktop Internet GIS client
 * http://udig.refractions.net
 * (C) 2004, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package org.locationtech.udig.tools.edit.support;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiLineString;
import com.vividsolutions.jts.geom.MultiPoint;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

/**
 * Enumerates the different types of Geometry types that a EditGeom can be.
 * 
 * @author jones
 * @since 1.1.0
 */
public enum ShapeType {
    UNKNOWN, POINT, LINE, POLYGON;

    public static ShapeType valueOf( Geometry geom ) {
        if( geom instanceof Point || geom instanceof MultiPoint)
            return POINT;
        if( geom instanceof LineString || geom instanceof LinearRing || geom instanceof MultiLineString)
            return LINE;
        if( geom instanceof Polygon || geom instanceof MultiPolygon)
            return POLYGON;
        
        return UNKNOWN;
    }

    public static ShapeType valueOf( Class type ) {
        if( Point.class.isAssignableFrom(type) || MultiPoint.class.isAssignableFrom(type))
            return POINT;
        if( LineString.class.isAssignableFrom(type) || LinearRing.class.isAssignableFrom(type)
                || MultiLineString.class.isAssignableFrom(type))
            return LINE;
        if( Polygon.class.isAssignableFrom(type) || MultiPolygon.class.isAssignableFrom(type) )
            return POLYGON;
        
        return UNKNOWN;
    }
}
