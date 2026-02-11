import { Activity, Calendar, TrendingUp, AlertCircle } from 'lucide-react'

export default function Oncology() {
  return (
    <div className="p-8">
      <div className="mb-8">
        <h1 className="text-3xl font-bold text-gray-800">Oncologia</h1>
        <p className="text-gray-600">Gestão de tratamentos oncológicos</p>
      </div>

      {/* Stats */}
      <div className="grid grid-cols-1 md:grid-cols-4 gap-6 mb-6">
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Tratamentos Ativos</p>
              <p className="text-3xl font-bold text-gray-800">156</p>
            </div>
            <Activity className="text-orange-600" size={40} />
          </div>
        </div>
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Sessões Hoje</p>
              <p className="text-3xl font-bold text-blue-600">24</p>
            </div>
            <Calendar className="text-blue-600" size={40} />
          </div>
        </div>
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Taxa de Conclusão</p>
              <p className="text-3xl font-bold text-green-600">87%</p>
            </div>
            <TrendingUp className="text-green-600" size={40} />
          </div>
        </div>
        <div className="bg-white rounded-lg shadow p-6">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-gray-600 text-sm mb-1">Atenção Necessária</p>
              <p className="text-3xl font-bold text-red-600">8</p>
            </div>
            <AlertCircle className="text-red-600" size={40} />
          </div>
        </div>
      </div>

      {/* Treatment List */}
      <div className="bg-white rounded-lg shadow">
        <div className="p-6 border-b">
          <h2 className="text-xl font-semibold">Tratamentos em Andamento</h2>
        </div>
        <div className="overflow-x-auto">
          <table className="w-full">
            <thead className="bg-gray-50 border-b">
              <tr>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Paciente</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Tipo</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Progresso</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Próxima Sessão</th>
                <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase">Status</th>
              </tr>
            </thead>
            <tbody className="divide-y">
              <TreatmentRow
                patient="Maria Silva Santos"
                type="Quimioterapia"
                completed={8}
                total={12}
                nextSession="15/02/2026"
                status="EM_ANDAMENTO"
              />
              <TreatmentRow
                patient="João Pedro Oliveira"
                type="Radioterapia"
                completed={15}
                total={20}
                nextSession="12/02/2026"
                status="EM_ANDAMENTO"
              />
              <TreatmentRow
                patient="Ana Carolina Costa"
                type="Imunoterapia"
                completed={4}
                total={10}
                nextSession="13/02/2026"
                status="EM_ANDAMENTO"
              />
              <TreatmentRow
                patient="Carlos Eduardo Lima"
                type="Quimioterapia"
                completed={10}
                total={12}
                nextSession="14/02/2026"
                status="EM_ANDAMENTO"
              />
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

function TreatmentRow({
  patient,
  type,
  completed,
  total,
  nextSession,
  status
}: {
  patient: string
  type: string
  completed: number
  total: number
  nextSession: string
  status: string
}) {
  const percentage = (completed / total) * 100

  return (
    <tr className="hover:bg-gray-50">
      <td className="px-6 py-4">
        <div className="font-medium text-gray-900">{patient}</div>
      </td>
      <td className="px-6 py-4">
        <span className="text-gray-700">{type}</span>
      </td>
      <td className="px-6 py-4">
        <div className="w-48">
          <div className="flex justify-between text-sm mb-1">
            <span className="text-gray-600">{completed}/{total} sessões</span>
            <span className="font-medium text-gray-700">{Math.round(percentage)}%</span>
          </div>
          <div className="w-full bg-gray-200 rounded-full h-2">
            <div 
              className="bg-orange-600 h-2 rounded-full transition-all"
              style={{ width: `${percentage}%` }}
            />
          </div>
        </div>
      </td>
      <td className="px-6 py-4 text-gray-700">{nextSession}</td>
      <td className="px-6 py-4">
        <span className="px-2 py-1 text-xs font-medium bg-blue-100 text-blue-800 rounded-full">
          {status}
        </span>
      </td>
    </tr>
  )
}
