/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pr.nb.zip.wizard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractListModel;
import org.openide.filesystems.FileObject;

/**
 *
 * @author Kaiser
 */
public class ExportArchiveListModel extends AbstractListModel<ExportArchiveListValueObject>{
    private List<ExportArchiveListValueObject> contents;

    public ExportArchiveListModel(List<ExportArchiveListValueObject> contents) {
        if(contents == null) throw new NullPointerException("Source list cannot be null");
        this.contents = new ArrayList<ExportArchiveListValueObject>(contents);
    }

    
    @Override
    public int getSize() {
        return contents.size();
    }

    @Override
    public ExportArchiveListValueObject getElementAt(int index) {
        if(!contents.isEmpty() && index < contents.size()){
            return contents.get(index);
        }
        return null;
    }
    public boolean addAll(List<ExportArchiveListValueObject> selItems){
        boolean retValue = contents.addAll(selItems);
        Collections.sort(contents);
        super.fireIntervalAdded(this, getSize(), getSize());
        return retValue;
    }

    public boolean removeAll(List<ExportArchiveListValueObject> selItems) {
        boolean retValue = contents.removeAll(selItems);
        super.fireIntervalRemoved(this, getSize(), getSize());
        return retValue;
    }
    public List<ExportArchiveListValueObject> getItems(){
        return new ArrayList<ExportArchiveListValueObject>(contents);
    }
}