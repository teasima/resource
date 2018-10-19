package guru.springframework.repositories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import guru.springframework.domain.Product;

@Repository
public class ProductDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Product> profit(List<String> houses, List<String> regions, List<String> citys, String st, String et) {
		List<Product> results = null;
		Product criteria = new Product();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery query = criteriaBuilder.createQuery(Product.class);
		Root<Product> root = query.from(Product.class);
		List<Predicate> list = new ArrayList<Predicate>();
		if (!CollectionUtils.isEmpty(houses)) {
			Path<Object> path = root.get("home_id");
			CriteriaBuilder.In<Object> in = criteriaBuilder.in(path);
			list.add(in.value(houses));
		}
		if (!CollectionUtils.isEmpty(regions)) {
			Path<Object> path = root.get("district");
			CriteriaBuilder.In<Object> in = criteriaBuilder.in(path);
			list.add(in.value(regions));
		}
		if (!CollectionUtils.isEmpty(citys)) {
			Path<Object> path = root.get("city");
			CriteriaBuilder.In<Object> in = criteriaBuilder.in(path);
			list.add(in.value(citys));
		}
		if (!StringUtils.isEmpty(st)) {
			list.add(criteriaBuilder.ge(root.get("month").as(Integer.class), Integer.valueOf(st)));
		}
		if (!StringUtils.isEmpty(et)) {
			list.add(criteriaBuilder.le(root.get("month").as(Integer.class), Integer.valueOf(et)));
		}
		Predicate[] predicates = new Predicate[list.size()];
		Predicate all = criteriaBuilder.and(list.toArray(predicates));

		List<Selection<?>> selections = new ArrayList<>();
		// 房源数
		selections.add(criteriaBuilder.countDistinct(root).alias("apartmentSum"));

		List<Expression<?>> groupByExpressions = new LinkedList<>();
		groupByExpressions.add(root.get("month"));
		query = query.multiselect(selections);
		query.where(all);
		query.groupBy(groupByExpressions);

		results = entityManager.createQuery(query).getResultList();
		return results;
	}

}
