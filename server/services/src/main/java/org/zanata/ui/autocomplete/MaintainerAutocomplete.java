package org.zanata.ui.autocomplete;

import java.util.List;

import org.zanata.dao.PersonDAO;
import org.zanata.model.HPerson;
import org.zanata.ui.AbstractAutocomplete;
import org.zanata.ui.FilterUtil;
import org.zanata.util.ServiceLocator;

/**
 * @author Alex Eng <a href="mailto:aeng@redhat.com">aeng@redhat.com</a>
 */
public abstract class MaintainerAutocomplete extends
        AbstractAutocomplete<HPerson> {

    private static final long serialVersionUID = -4245346746883339439L;
    protected PersonDAO personDAO = ServiceLocator.instance().getInstance(
            PersonDAO.class);

    protected abstract List<HPerson> getMaintainers();

    @Override
    public List<HPerson> suggest() {
        List<HPerson> personList = personDAO.findAllEnabledContainingName(getQuery());
        return FilterUtil.filterOutPersonList(getMaintainers(), personList);
    }
}
