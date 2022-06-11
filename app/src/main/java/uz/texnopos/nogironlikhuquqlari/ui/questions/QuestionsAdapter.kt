package uz.texnopos.nogironlikhuquqlari.ui.questions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.nogironlikhuquqlari.R
import uz.texnopos.nogironlikhuquqlari.core.onClick
import uz.texnopos.nogironlikhuquqlari.data.entities.Question
import uz.texnopos.nogironlikhuquqlari.databinding.ItemQuestionBinding

class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>() {

    inner class QuestionsViewHolder(private val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun populateModel(question: Question) {
            binding.orderNumber.text=binding.root.context.getString(R.string.order,question.id)
            binding.tvQuestion.text = question.title
            binding.cardView.onClick {
                try{
                    onClick.invoke(question)
                }catch (e:Exception){}
            }
        }
    }

    var models: List<Question> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private var onClick: (question: Question) -> Unit = {}
    fun setOnItemClickListener(onClick: (question: Question) -> Unit) {
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        val binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }
}