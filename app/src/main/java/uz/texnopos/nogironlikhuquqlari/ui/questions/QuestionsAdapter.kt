package uz.texnopos.mehrtilsimi.ui.questions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.mehrtilsimi.data.entities.Question
import uz.texnopos.mehrtilsimi.databinding.ItemQuestionBinding

class QuestionsAdapter: RecyclerView.Adapter<QuestionsAdapter.QuestionsViewHolder>() {

    inner class QuestionsViewHolder(private val binding: ItemQuestionBinding): RecyclerView.ViewHolder(binding.root){
        fun populateModel(questions: Question){
            binding.tvQuestion.text = questions.title
        }
    }

    var models : List<Question> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
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