USE world;
-- 각 테이블의 내용을 확인 하자.
select *
from city;
select *
from country;

select  *
From countrylanguage;
-- Q1. 모든 도시(city)의 이름과 해당 국가(country)의 이름을 출력하되, 각각 City와 Country라는 별칭으로 표시하자.
-- ANSI
    select city.Name as city, country.Name as country
    from city
    join country on (city.CountryCode = country.Code);
-- MYSQL
    select city.name as city, country.name as country
    from city, country
    where city.CountryCode = Country.Code;

-- Q2. 인구 수가 100만 이상인 도시 이름, 인구, 해당 국가 이름을 출력하되, 도시의 인구가 기준이다.
-- ANSI
        select city.Name, city.Population, country.Name
        from city
        join country on(city.CountryCode = country.code)
        where city.Population>100000;
-- MYSQL
    select city.Name, city.Population, country.Name
    from city, country
    where city.Population>100000;

-- Q3. 도시 이름, 국가 코드, 해당 도시가 속한 국가에서 사용되는 언어를 출력하자.
-- ANSI
select name, city.CountryCode,countrylanguage.language
from city
         join countrylanguage using(CountryCode);
-- MYSQL
select city.name, city.countryCode, countrylanguage.language
from city, countrylanguage
where city.CountryCode = countrylanguage.CountryCode;


-- Q4. 공용 언어(IsOfficial='T')만 골라 언어 이름과 해당 국가 이름을 출력하자.
-- ANSI


-- MYSQL
    select countrylanguage.Language as language, country.name as country
    from country, countrylanguage
    where countrylanguage.CountryCode = country.code and
        IsOfficial = 'T';


-- Q5. 아시아 대륙에 속한 국가에 있는 도시의 이름과 인구를 출력하자.
-- ANSI
-- MYSQL
    select city.Name, city.Population
    from city, country
    where CountryCode = code and
        Continent = 'Asia';

-- Q6. 기대 수명(LifeExpectancy)이 80 이상인 국가의 이름과 대륙을 출력하자.
-- ANSI
-- MYSQL
    select country.Name, country.Continent
    from country
    where LifeExpectancy>=80;

-- Q7. 공용어가 영어인 국가의 이름만 출력하자.
-- ANSI
-- MYSQL
    select country.name
    from country, countrylanguage
    where countrylanguage.IsOfficial = 'T' and countrylanguage.Language = 'English'
    and country.code = countrylanguage.CountryCode;

-- Q8. 모든 국가의 이름과 수도 도시의 이름을 각각 Country, Capital로 별칭을 주어 출력하자.
-- ANSI
-- MYSQL
    select country.Name as country, city.Name as Capital
    from country, city
    where country.Capital = city.ID;

-- Q9. 도시 이름, 도시 인구, 해당 국가의 지역(region)을 출력하자.
-- ANSI
# select city.Name, city.Population, country.Region
# from city, country
# where country on countrycode = country code
    select city.Name, city.Population, country.Region
    from city, country
    where city.CountryCode = country.code;

-- Q10. 인구가 500만 이상인 국가에서 사용되는 언어를 해당 국가 이름과 함께 출력하자.
-- ANSI
-- MYSQL
    select countrylanguage.Language, country.Name
    from countrylanguage, country
    where Population>5000000 and CountryCode = Code;

-- Q11. 도시 이름과 해당 국가의 정부 형태(GovernmentForm)를 출력하자.
-- ANSI
-- MYSQL
    select city.Name, country.GovernmentForm
    from city, country
    where city.CountryCode = country.Code;

-- Q12. 공용어가 영어인 국가에 속한 도시 이름을 중복 없이 출력하자.
-- ANSI
-- MYSQL
    select distinct city.Name
    from city, countrylanguage
    where Language = 'English' and city.CountryCode = countrylanguage.CountryCode

-- Q13. 국가 이름과 그 국가에서 사용되는 언어 이름을 출력하자.
-- ANSI
-- MYSQL
    select country.Name, countrylanguage.Language
    from country, countrylanguage
    where CountryCode = Code;

-- Q14. 모든 국가의 이름과 수도 도시의 인구를 출력하자.
-- ANSI
-- MYSQL
# select * from country

    select country.Name, city.Population
    from country, city
    where country.Capital = city.ID;

-- Q15. 도시 이름과 해당 국가의 독립 연도(IndepYear)를 출력하자.
-- ANSI
-- MYSQL
    select city.Name, country.IndepYear
    from city, country
    where country.code = city.CountryCode;

-- Q16. 사용 언어 수가 5개 이상인 국가의 이름을 출력하자.
-- ANSI
-- MYSQL
select country.Name
from country, countrylanguage
where CountryCode = Code
group by country.Name
having Count(Language)>=5;
-- Q17. 도시 이름과 그 도시가 속한 국가의 국토 면적(SurfaceArea)을 출력하자.
-- ANSI
-- MYSQL

    select city.Name, country.SurfaceArea
    from city, country
    where city.CountryCode = Code;

-- Q18. 아프리카 대륙에 속한 국가의 이름과 수도 도시 이름을 출력하자.
-- ANSI
-- MYSQL

select * from country;

    select country.Name, city.Name
    from city, country
    where country.Capital = city.ID and country.Region like '%Africa'

-- Q19. 전 세계에서 인구가 가장 많은 도시의 이름과 그 도시가 속한 국가 이름을 출력하자.
-- ANSI
-- MYSQL

    select city.Name as cityname, country.Name as countryname
    from city
    join country on city.CountryCode = country.Code
    order by city.Population desc
    limit 1;

-- Q20. 도시 인구의 평균이 100만 이상인 국가의 이름을 출력하자.
-- ANSI
-- MYSQL

    select country.Name
    from country
    join city on country.Code = city.CountryCode
    group by country.Name
    having avg(city.Population)>=1000000;

-- Q21. 도시 정보가 없는 국가를 출력하자 ->
