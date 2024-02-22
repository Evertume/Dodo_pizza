package com.example.dodopizza

// Import necessary Android and Kotlin libraries
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Define the Pizza data class
data class Pizza(val name: String, val description: String, val image: Int)

class MainActivity : AppCompatActivity() {
    // Initialize an empty list of Pizzas
    private var pizzas: List<Pizza> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Populate the pizzas list
        pizzas = listOf(
            Pizza("Margherita", "Classic Italian pizza with tomatoes, mozzarella, and basil", R.drawable.margherita),
            Pizza("Pepperoni", "American favorite with pepperoni, mozzarella, and tomato sauce", R.drawable.pepperoni),
            // Add more pizzas here...
        )

        // Set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PizzaAdapter(pizzas)
    }
}

// Define the PizzaAdapter class
class PizzaAdapter(private val pizzas: List<Pizza>) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {
    // Define the PizzaViewHolder class
    class PizzaViewHolder(val pizzaView: PizzaView) : RecyclerView.ViewHolder(pizzaView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val pizzaView = LayoutInflater.from(parent.context).inflate(R.layout.pizza_view, parent, false) as PizzaView
        return PizzaViewHolder(pizzaView)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.pizzaView.setPizza(pizzas[position])
    }

    override fun getItemCount() = pizzas.size
}
