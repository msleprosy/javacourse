package com.epam.javacourse.country.repository.implementation;

import com.epam.javacourse.common.business.search.Paginator;
import com.epam.javacourse.common.solutions.utils.CollectionUtils;
import com.epam.javacourse.country.domain.Country;
import com.epam.javacourse.country.repository.CountryRepository;
import com.epam.javacourse.country.search.CountrySearchCondition;
import com.epam.javacourse.storage.SequenceGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.epam.javacourse.common.solutions.utils.StringUtils.isNotBlank;
import static com.epam.javacourse.storage.Storage.countries;

public class CountryMemoryCollectionRepository implements CountryRepository {
    private CountryOrderingComponent orderingComponent = new CountryOrderingComponent();

    @Override
    public Country add(Country country) {
        country.setId(SequenceGenerator.getNextValue());
        countries.add(country);

        return country;
    }

    @Override
    public void add(Collection<Country> countries) {
        countries.forEach(this::add);
    }

    @Override
    public void update(Country country) {

    }

    @Override
    public void deleteById(Long id) {
        Optional<Country> foundOptional = findCountryById(id);
        foundOptional.map(mark -> countries.remove(mark));
    }

    @Override
    public List<Country> search(CountrySearchCondition searchCondition) {
/*        if (searchCondition.getId() != null) {
            return Collections.singletonList(findById(searchCondition.getId()));
        } else {*/
        List<Country> result = doSearch(searchCondition);

        boolean needOrdering = !result.isEmpty() && searchCondition.needOrdering();
        if (needOrdering) {
            orderingComponent.applyOrdering(result, searchCondition);
        }

        if (!result.isEmpty() && searchCondition.shouldPaginate()) {
            result = getPageableData(result, searchCondition.getPaginator());
        }

        return result;
    }


    @Override
    public void printAll() {
        countries.forEach(System.out::println);
    }

    @Override
    public List<Country> findAll() {
        return countries;
    }

    @Override
    public int countAll() {
        return countries.size();
    }

    @Override
    public Optional<Country> findById(Long id) {
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

    private Optional<Country> findCountryById(long countryId) {
        return countries.stream().filter(country -> Long.valueOf(countryId).equals(country.getId())).findAny();
    }

    private List<Country> getPageableData(List<Country> countries, Paginator paginator) {
        return CollectionUtils.getPageableData(countries, paginator.getLimit(), paginator.getOffset());
    }

/*    private void deleteCountryByName(String nameForDeleting) {
        Iterator<Country> iter = countries.iterator();
        while (iter.hasNext()) {
            String countryName = iter.next().getName();
            if (countryName.equals(nameForDeleting)) {
                iter.remove();
            }
        }
    }*/
}
