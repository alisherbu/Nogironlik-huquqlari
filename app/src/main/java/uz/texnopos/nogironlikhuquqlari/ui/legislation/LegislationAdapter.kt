package uz.texnopos.nogironlikhuquqlari.ui.legislation

import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.data.entities.Legislation
import uz.texnopos.nogironlikhuquqlari.databinding.ItemLegislationBinding

class LegislationAdapter: RecyclerView.Adapter<LegislationAdapter.LegislationViewHolder>() {

    inner class LegislationViewHolder(private val binding: ItemLegislationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun populateModel(legislation: Legislation) {
            binding.tvLegislation.text = legislation.year.toString()
            binding.cardView.onClick {
                onClick.invoke(legislation)
            }
        }
    }

    private var onClick: (legislation: Legislation) -> Unit = {}
    fun setOnItemClickListener(onClick: (legislation: Legislation) -> Unit) {
        this.onClick = onClick
    }

    var models = listOf<Legislation>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegislationViewHolder {
        val binding = ItemLegislationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LegislationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LegislationViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
}