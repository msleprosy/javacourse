package com.epam.javacourse.country.repository.implementation;

import com.epam.javacourse.common.business.domain.BaseDomain;
import com.epam.javacourse.common.business.search.BaseSearchCondition;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.memory.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.memory.Memory.countries;

public class CountryMemoryCollectionRepository implements CountryRepository {
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();

    @Override
    public void add(BaseDomain country) {
        country.setId(SequenceGenerator.getNextValue());
        countries.add((Country) country);
    }

    @Override
    public void update(BaseDomain type) {

    }

    @Override
    public void deleteById(long id) {
        Country found = findCountryById(id);
        if (found != null) {
            countries.remove(found);
        }
    }

    @Override
    public void deleteByName(String nameForDeleting) {
        deleteCountryByName(nameForDeleting);
    }

   /* @Override
    public void update(Country country) {
    }*/


   /* @Override
    public Country findByName(String countryName) {
        for (Country country : countries) {
            if (countryName.equals(country.getName())) {
                return country;
            }
        }
        return null;
    }*/

   /* @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<Country> result = doSearch(searchCondition);

            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
            if (needOrdering) {
                orderingComponent.applyOrdering(result, searchCondition);
            }

            return result;
        }
    }
*/
    @Override
    public void printAll() {
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    @Override
    public List search(BaseSearchCondition searchCondition) {
        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {
            List<Country> result = doSearch((CountrySearchCondition) searchCondition);

            boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
            if (needOrdering) {
                orderingComponent.applyOrdering(result, ((CountrySearchCondition)searchCondition));
            }

            return result;
        }
    }

    private Country findById(Long id) {
        return findCountryById(id);
    }

    private List<Country> doSearch(CountrySearchCondition searchCondition) {
        boolean searchByName = isNotBlank(searchCondition.getName());

        List<Country> result = new ArrayList<>();
        for (Country country : countries) {
            if (country != null) {
                boolean found = true;

                if (searchByName) {
                    found = searchCondition.getName().equals(country.getName());
                }

                if (found) {
                    result.add(country);
                }
            }
        }
        return result;
    }

    private Country findCountryById(long countryId) {
        for (Country country : countries) {
            if (Long.valueOf(countryId).equals(country.getId())) {
                return country;
            }
        }
        return null;
    }

    private void deleteCountryByName(String nameForDeleting) {
        Iterator<Country> iter = countries.iterator();
        while (iter.hasNext()) {
            String countryName = iter.next().getName();
            if (countryName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }
}
