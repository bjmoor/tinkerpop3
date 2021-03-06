/**
Copyright (C) SYSTAP, LLC DBA Blazegraph 2006-2016.  All rights reserved.

Contact:
     SYSTAP, LLC DBA Blazegraph
     2501 Calvert ST NW #106
     Washington, DC 20008
     licenses@blazegraph.com

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; version 2 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package com.blazegraph.gremlin.structure;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A property graph version of a tuple query result binding set.  Instead of
 * variable names to RDF values, this does variable names to PG values (element
 * ids, property keys, property values). 
 * 
 * @author mikepersonick
 */
public class BlazeBindingSet implements Iterable<Map.Entry<String,Object>> {
        
    /**
     * The variable bindings - variable name to PG value.
     */
    private final Map<String, Object> vals;
    
    /**
     * Construct an instance.
     */
    BlazeBindingSet(final Map<String, Object> vals) {
        this.vals = vals;
    }
    
    /**
     * Get the PG value (element id, property key, or property value) for the
     * specified variable.
     */
    public Object get(final String var) {
        return vals.get(var);
    }

    /**
     * True if the binding set has a PG value for the specified variable.
     */
    public boolean isBound(final String var) {
        return vals.containsKey(var);
    }

    /**
     * A unmodifiable set of variables bound in this binding set.
     */
    public Set<String> vars() {
        return Collections.unmodifiableSet(vals.keySet());
    }
    
    /**
     * An unmodifiable map of variable bindings - variable name to PG value.
     */
    public Map<String, Object> map() {
        return Collections.unmodifiableMap(vals);
    }

    /**
     * An iterator of variable bindings - variable name to PG value.
     */
    @Override
    public Iterator<Map.Entry<String,Object>> iterator() {
        return vals.entrySet().iterator();
    }

    @Override
    public String toString() {
        return "BlazeBindingSet [vals=" + vals + "]";
    }
    
}
