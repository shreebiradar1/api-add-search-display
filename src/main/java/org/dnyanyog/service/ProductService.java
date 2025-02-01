package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DatabaseUtil;
import org.dnyanyog.dto.Product;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
	// Adding Product Logic
		public List<String> addProduct(Product prod) {
			ArrayList<String> product = new ArrayList<>();

			String query = "Insert into product (productName, price, quantity) " + "Values ('" + prod.getName() + "', "
					+ prod.getPrice() + ", " + prod.getQuantity() + ");";

			try {
				Statement statement = DatabaseUtil.productConnection().createStatement();
				statement.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return product;
		}

		// Search User Logic
		public String search(String prodname) {
			String query = "Select * from product where productname = '" + prodname + "';";

			try {
				ResultSet result = DatabaseUtil.executeProduct(query);
				result.next();

				String productData = "Name: " + result.getString(1) + ", Price: " + result.getString(2) + ", Quantity: "
						+ result.getString(3);

				return productData;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Something is off";
			}
		}

		// Display all user
		public List<String> getProduct() throws SQLException {
			String query = "Select * from product";

			ArrayList<String> product = new ArrayList<>();

			ResultSet rs = DatabaseUtil.executeProduct(query);
			while (rs.next()) {
				for (int i = 1; i < 4; i++) {
					product.add(rs.getString(i));
				}

			}

			return product;

		}
}
