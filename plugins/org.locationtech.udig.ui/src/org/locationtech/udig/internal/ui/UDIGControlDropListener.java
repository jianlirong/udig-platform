/*
 *    uDig - User Friendly Desktop Internet GIS client
 *    http://udig.refractions.net
 *    (C) 2012, Refractions Research Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * (http://www.eclipse.org/legal/epl-v10.html), and the Refractions BSD
 * License v1.0 (http://udig.refractions.net/files/bsd3-v10.html).
 */
package org.locationtech.udig.internal.ui;

import org.locationtech.udig.ui.UDIGDropTargetListener;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;

public class UDIGControlDropListener extends DropTargetAdapter implements UDIGDropTargetListener{


    UDIGDropHandler handler;
    private IDropTargetProvider destinationProvider;


	public UDIGControlDropListener(IDropTargetProvider destinationProvider, UDIGDropHandler dropHandler) {
		handler = dropHandler;
        if( destinationProvider==null )
            destinationProvider=new NullProvider();
        this.destinationProvider=destinationProvider;		
	}
    private void initHandler(DropTargetEvent event) {
        handler.setTarget(destinationProvider.getTarget(event));
    }

    public void dragEnter( DropTargetEvent event ) {
	    initHandler(event);
        handler.dragEnter(event);
    }

    public void dragOperationChanged( DropTargetEvent event ) {
        initHandler(event);
        handler.dragOperationChanged(event);
    }

    @Override
    public void dragLeave( DropTargetEvent event ) {
        initHandler(event);
        handler.dragLeave(event);
    }
    @Override
    public void dragOver( DropTargetEvent event ) {
        initHandler(event);
        handler.dragOver(event);
    }
    @Override
    public void dropAccept( DropTargetEvent event ) {
        initHandler(event);
        handler.dropAccept(event);
    }
    public void drop(DropTargetEvent event ) {
        initHandler(event);
		handler.drop(event);
	}

    public UDIGDropHandler getHandler() {
    	return handler;
    }
    
    /**
     * Returns nulls
     * @author jones
     * @since 1.0.0
     */
    public static class NullProvider implements ISelectionProvider, IDropTargetProvider {

        public void addSelectionChangedListener( ISelectionChangedListener listener ) {
        }

        public ISelection getSelection() {
            return new StructuredSelection();
        }

        public void removeSelectionChangedListener( ISelectionChangedListener listener ) {
        }

        public void setSelection( ISelection selection ) {
        }

        public Object getTarget(DropTargetEvent event  ) {
            return null;
        }

    }

    public IDropTargetProvider getDropTargetProvider() {
        return destinationProvider;
    }
    public void setDropTargetProvider( IDropTargetProvider newProvider ) {
        destinationProvider=newProvider;
    }   
}
