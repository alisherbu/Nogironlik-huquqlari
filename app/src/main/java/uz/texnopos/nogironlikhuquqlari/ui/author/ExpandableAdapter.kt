package uz.texnopos.nogironlikhuquqlari.ui.author

import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.createDynamicViews
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.data.entities.Author
import uz.texnopos.nogironlikhuquqlari.databinding.ItemExpandBinding


class ExpandableAdapter : RecyclerView.Adapter<ExpandableAdapter.ViewHolder>() {
    var last = 0

    inner class ViewHolder(private val bind: ItemExpandBinding) :
        RecyclerView.ViewHolder(bind.root) {
        fun populateModel(model: Author, position: Int) {
            createDynamicViews(model.text!!, bind.blockDesc.context, bind.blockDesc)
            bind.description.movementMethod = LinkMovementMethod.getInstance()
            bind.title.text = model.title
//        bind.description.text=HtmlCompat.fromHtml(model.text!!,HtmlCompat.FROM_HTML_MODE_COMPACT)
            update(model)
            bind.blockTitle.onClick {
                model.isExpand = if (model.isExpand == 0) 1 else 0
                update(model)
            }
        }

        fun update(model: Author) {
            if (model.isExpand == 1) {
                bind.blockDesc.visibility = View.VISIBLE
                bind.expand.setImageResource(R.drawable.arrow_up)
            } else {
                bind.blockDesc.visibility = View.GONE
                bind.expand.setImageResource(R.drawable.arrow_down)
            }
        }
    }

    var models: List<Author> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = ItemExpandBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

    override fun getItemCount() = models.size


}
